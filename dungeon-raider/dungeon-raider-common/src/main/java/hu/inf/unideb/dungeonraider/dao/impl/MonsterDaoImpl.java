package hu.inf.unideb.dungeonraider.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import hu.inf.unideb.dungeonraider.dao.MonsterDao;
import hu.inf.unideb.dungeonraider.domain.Monster;

/**
 * Default implementation of the monster DAO.
 * 
 * @author fv
 */
@Repository("monsterDao")
public class MonsterDaoImpl extends HibernateDaoSupport implements MonsterDao {

	@Override
	public Monster findById(int id) {
		Monster monster = getHibernateTemplate().get(Monster.class, id);
		getHibernateTemplate().initialize(monster);
		return monster;
	}

}
