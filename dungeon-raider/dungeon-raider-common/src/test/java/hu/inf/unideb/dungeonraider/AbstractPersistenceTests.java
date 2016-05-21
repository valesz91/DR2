package hu.inf.unideb.dungeonraider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Abstract class of persistence tests.
 * 
 * @author hp
 */
public class AbstractPersistenceTests extends AbstractTransactionalJUnit4SpringContextTests implements ResourceLoaderAware {

	/** Jackson object mapper */
	private final ObjectMapper objectMapper = new ObjectMapper();
	/** Hibernate session factory */
	private SessionFactory sessionFactory;
	/** Spring resource loader */
	private ResourceLoader resourceLoader;

	/**
	 * Abstract persistence test.
	 */
	public AbstractPersistenceTests() {
	}

	/**
	 * Bind and save entities.
	 * 
	 * @param location the location, not blank
	 * @param clazz the entity class, not <code>null</code>
	 * @return the list of entities
	 * @throws IOException
	 */
	protected <T> List<T> bindAndSaveEntities(String location, Class<T> clazz) throws IOException {

		List<T> list = bindEntities(location, clazz);
		saveAll(list);

		return list;
	}

	/**
	 * Bind entities.
	 * 
	 * @param location the location, not blank
	 * @param clazz the entity class, not <code>null</code>
	 * @return the list of entities
	 * @throws IOException
	 */
	protected <T> List<T> bindEntities(String location, Class<T> clazz) throws IOException {

		Assert.hasText(location);
		Assert.notNull(clazz);

		Resource resource = resourceLoader.getResource(location);
		Assert.isTrue(resource.exists());

		try (Reader reader = new InputStreamReader(resource.getInputStream(), "UTF-8")) {
			return objectMapper.readValue(reader, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
		}
	}

	/**
	 * Flush and clear the current Hibernate session.
	 */
	protected void flushAndClear() {

		Session session = sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * List all entities of a given type.
	 * 
	 * @param clazz the class, not <code>null</code>
	 * @return the list of entities
	 */
	protected <T> List<T> listAll(Class<T> clazz) {

		Assert.notNull(clazz);

		@SuppressWarnings("unchecked")
		List<T> list = sessionFactory.getCurrentSession().createCriteria(clazz).list();
		return list;
	}

	/**
	 * List entities with property values equal to the given values.
	 * 
	 * @param clazz the entity class, not <code>null</code>
	 * @param args the sequence of property names and values, not empty
	 * @return the count
	 */
	protected <T> List<T> listPropertiesEq(Class<T> clazz, Object... args) {

		Assert.notNull(clazz);
		Assert.notEmpty(args);
		Assert.isTrue(args.length % 2 == 0);

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		if (args != null) {
			for (int i = 0; i < args.length; i += 2) {
				Property property = Property.forName((String) args[i]);
				Object value = args[i + 1];
				criteria.add(value == null ? property.isNull() : property.eq(value));
			}
		}

		@SuppressWarnings("unchecked")
		List<T> list = criteria.list();
		return list;
	}

	/**
	 * QueryActionPrint JSON template of entities.
	 * 
	 * @param clazz the class, not <code>null</code>
	 * @param count the entity count, greater than <code>0</code>
	 */
	protected void printTemplate(Class<?> clazz, int count) throws IOException {

		Assert.notNull(clazz);
		Assert.isTrue(0 < count);

		Object bean = BeanUtils.instantiateClass(clazz);
		Object[] array = new Object[count];
		Arrays.fill(array, bean);

		String template = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(array);
		System.out.println(template);
	}

	/**
	 * Save all entities.
	 * 
	 * @param collection the collection
	 */
	protected void saveAll(Collection<?> collection) {

		if (!CollectionUtils.isEmpty(collection)) {
			for (Object entity : collection) {
				sessionFactory.getCurrentSession().save(entity);
			}
			flushAndClear();
		}
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
