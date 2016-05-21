package hu.inf.unideb.dungeonraider.dao;

import hu.inf.unideb.dungeonraider.domain.Monster;

public interface MonsterDao {

	/**
	 * Find Monster entity by id.
	 * 
	 * @param id the id
	 * @return the monster or <code>null</code>
	 */
	Monster findById(int id);

}
