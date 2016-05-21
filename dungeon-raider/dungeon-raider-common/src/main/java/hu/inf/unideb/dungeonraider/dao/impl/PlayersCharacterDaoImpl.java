package hu.inf.unideb.dungeonraider.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import hu.inf.unideb.dungeonraider.dao.PlayersCharacterDao;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;

/**
 * Default implementation of the creature DAO.
 * 
 * @author fv
 */
@Repository("playercharacterDao")
public class PlayersCharacterDaoImpl extends HibernateDaoSupport implements PlayersCharacterDao {

	@Override
	public PlayersCharacter findByNameAndPassword(String name, String password) {

		DetachedCriteria criteria = DetachedCriteria.forClass(PlayersCharacter.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));

		@SuppressWarnings("unchecked")
		List<PlayersCharacter> characters = (List<PlayersCharacter>) getHibernateTemplate().findByCriteria(criteria);
		return DataAccessUtils.singleResult(characters);
	}

	@Override
	public PlayersCharacter findByName(String name) {

		DetachedCriteria criteria = DetachedCriteria.forClass(PlayersCharacter.class);
		criteria.add(Restrictions.eq("name", name));

		@SuppressWarnings("unchecked")
		List<PlayersCharacter> characters = (List<PlayersCharacter>) getHibernateTemplate().findByCriteria(criteria);
		return DataAccessUtils.singleResult(characters);
	}

	@Override
	public PlayersCharacter findById(Integer id) {
		PlayersCharacter pc = getHibernateTemplate().get(PlayersCharacter.class, id);
		getHibernateTemplate().initialize(pc);
		return pc;
	}

	@Override
	public void saveOrUpdatePlayersCharacter(PlayersCharacter character) {
		getHibernateTemplate().saveOrUpdate(character);
	}

	@Override
	public void deletePlayersCharacter(PlayersCharacter character) {
		getHibernateTemplate().delete(character);
	}

}
