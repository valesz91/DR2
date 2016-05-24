package hu.inf.unideb.dungeonraider.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

/**
 * Default implementation of the item DAO.
 * 
 * @author fv
 */
@Repository("itemDao")
public interface ItemDao {

	/**
	 * Find armor by ID.
	 * 
	 * @param id the armor's id
	 * @return the persistenced armor or <code>null</code>
	 */
	Armor findArmorById(int id);

	/**
	 * Find weapon by ID.
	 * 
	 * @param id the weapon's id
	 * @return the persistenced weapon or <code>null</code>
	 */
	Weapon findWeaponById(int id);

	/**
	 * Find shield by ID.
	 * 
	 * @param id the shield's id
	 * @return the persistenced shield or <code>null</code>
	 */
	Shield findShieldById(int id);

	/**
	 * Find weapon by ID.
	 * 
	 * @param id the weapon's id
	 * @return the persistenced weapon or <code>null</code>
	 */
	Potion findPotionById(int id);

	/**
	 * Save or update a weapon entity.
	 * 
	 * @param weapon <code>not null</code>
	 */
	void saveOrUpdateWeapon(Weapon weapon);

	/**
	 * Save or update an armor entity.
	 * 
	 * @param armor <code>not null</code>
	 */
	void saveOrUpdateArmor(Armor armor);

	/**
	 * Save or update a weapon entity.
	 * 
	 * @param weapon <code>not null</code>
	 */
	void saveOrUpdatePotion(Potion weapon);

	/**
	 * Save or update a shield entity.
	 * 
	 * @param shield <code>not null</code>
	 */
	void saveOrUpdateShield(Shield shield);

	/**
	 * Count all saved armors.
	 * 
	 * @return the number of all saved armors.
	 */
	int countArmors();

	/**
	 * Count all saved weapons.
	 * 
	 * @return the number of all saved weapons.
	 * 
	 */
	int countWeapons();

	/**
	 * Count all saved shields.
	 * 
	 * @return the number of all saved shields.
	 * 
	 */
	int countShields();

	/**
	 * Count all saved weapons.
	 * 
	 * @return the number of all saved weapons.
	 * 
	 */
	int countPotions();

	/**
	 * List of all saved weapons, restricted by the value of the weapon.
	 * 
	 * @param totalResults the number of total results
	 * @param maxPrice the max value of the item
	 * @return the <code>list</code> of weapons or <code>null</code>.
	 */
	List<Potion> listAllPotion(int totalResults, Integer maxPrice);

	/**
	 * List of all saved shields, restricted by the value of the shield.
	 * 
	 * @param totalResults the number of total results
	 * @param maxPrice the max value of the item
	 * @return the <code>list</code> of shields or <code>null</code>.
	 */
	List<Shield> listAllShield(int totalResults, Integer maxPrice);

	/**
	 * List of all saved weapons, restricted by the value of the weapon.
	 * 
	 * @param totalResults the number of total results
	 * @param maxPrice the max value of the item
	 * @return the <code>list</code> of weapons or <code>null</code>.
	 */
	List<Weapon> listAllWeapon(int totalResults, Integer maxPrice);

	/**
	 * List of all saved armors, restricted by the value of the armor.
	 * 
	 * @param totalResults the number of total results
	 * @param maxPrice the max value of the item
	 * @return the <code>list</code> of armors or <code>null</code>.
	 */
	List<Armor> listAllArmor(int totalResults, Integer maxPrice);

}
