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

	Armor findArmorById(int id);

	Weapon findWeaponById(int id);

	Potion findPotionById(int id);

	void saveOrUpdateWeapon(Weapon weapon);

	void saveOrUpdateArmor(Armor armor);

	void saveOrUpdatePotion(Potion potion);

	int countArmors();

	int countWeapons();

	int countShields();

	int countPotions();

	List<Potion> listAllPotion(int totalResults, Integer maxPrice);

	List<Shield> listAllShield(int totalResults, Integer maxPrice);

	List<Weapon> listAllWeapon(int totalResults, Integer maxPrice);

	List<Armor> listAllArmor(int totalResults, Integer maxPrice);

	Shield findShieldById(int id);

	void saveOrUpdateShield(Shield shield);

}
