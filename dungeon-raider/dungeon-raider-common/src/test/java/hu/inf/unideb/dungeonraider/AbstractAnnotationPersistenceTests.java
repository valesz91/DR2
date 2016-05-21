package hu.inf.unideb.dungeonraider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Abstract persistence tests for annotated configurations.
 * 
 * @author fv
 */
public class AbstractAnnotationPersistenceTests {

	/** Jackson object mapper */
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Abstract persistence tests for annotated configurations.
	 */
	public AbstractAnnotationPersistenceTests() {
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
}
