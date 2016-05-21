package hu.inf.unideb.dungeonraider.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import hu.inf.unideb.dungeonraider.dao.ItemDao;
import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

public class ItemDaoImpl extends HibernateDaoSupport implements ItemDao {

	@Override
	public int countArmors() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Armor.class);
		return DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount())));

	}

	@Override
	public int countWeapons() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Weapon.class);
		return DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount())));

	}

	@Override
	public int countShields() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Shield.class);
		return DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount())));

	}

	@Override
	public int countPotions() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Potion.class);
		return DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount())));

	}

	@Override
	public Armor findArmorById(int id) {
		Armor armor = getHibernateTemplate().get(Armor.class, id);
		getHibernateTemplate().initialize(armor);
		return armor;
	}

	@Override
	public Weapon findWeaponById(int id) {
		Weapon weapon = getHibernateTemplate().get(Weapon.class, id);
		getHibernateTemplate().initialize(weapon);
		return weapon;
	}

	@Override
	public Potion findPotionById(int id) {
		Potion potion = getHibernateTemplate().get(Potion.class, id);
		getHibernateTemplate().initialize(potion);
		return potion;
	}

	@Override
	public Shield findShieldById(int id) {
		Shield shield = getHibernateTemplate().get(Shield.class, id);
		getHibernateTemplate().initialize(shield);
		return shield;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Armor> listAllArmor(int totalResults, Integer maxPrice) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Armor.class);

		if (maxPrice != null) {
			criteria.add(Restrictions.le("value", maxPrice));
		}

		List<Armor> list = (List<Armor>) getHibernateTemplate().findByCriteria(criteria, 0, totalResults);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Weapon> listAllWeapon(int totalResults, Integer maxPrice) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Weapon.class);

		if (maxPrice != null) {
			criteria.add(Restrictions.le("value", maxPrice));
		}

		List<Weapon> list = (List<Weapon>) getHibernateTemplate().findByCriteria(criteria, 0, totalResults);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shield> listAllShield(int totalResults, Integer maxPrice) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Shield.class);

		if (maxPrice != null) {
			criteria.add(Restrictions.le("value", maxPrice));
		}

		List<Shield> list = (List<Shield>) getHibernateTemplate().findByCriteria(criteria, 0, totalResults);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Potion> listAllPotion(int totalResults, Integer maxPrice) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Potion.class);

		if (maxPrice != null) {
			criteria.add(Restrictions.le("value", maxPrice));
		}

		List<Potion> list = (List<Potion>) getHibernateTemplate().findByCriteria(criteria, 0, totalResults);
		return list;
	}

	@Override
	public void saveOrUpdateWeapon(Weapon weapon) {
		getHibernateTemplate().saveOrUpdate(weapon);
	}

	@Override
	public void saveOrUpdateArmor(Armor armor) {
		getHibernateTemplate().saveOrUpdate(armor);
	}

	@Override
	public void saveOrUpdatePotion(Potion potion) {
		getHibernateTemplate().saveOrUpdate(potion);
	}

	@Override
	public void saveOrUpdateShield(Shield shield) {
		getHibernateTemplate().saveOrUpdate(shield);
	}

}
