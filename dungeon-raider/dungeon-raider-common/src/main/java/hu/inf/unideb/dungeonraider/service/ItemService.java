package hu.inf.unideb.dungeonraider.service;

import java.util.List;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

/**
 * Default interface of item service.
 * 
 * @author FV
 *
 */
public interface ItemService {

	/**
	 * List of potions wich character able to buy.
	 * 
	 * @param characterId the character Id
	 * @param canBuy <code>true</code> if is the list just contains the potions wich the character can buy
	 * @return the list of potions
	 */
	List<Potion> listPotions(int characterId, boolean canBuy);

	/**
	 * List of shields wich character able to buy.
	 * 
	 * @param characterId the character Id
	 * @param canBuy <code>true</code> if is the list just contains the shields wich the character can buy
	 * @return the list of shields
	 */
	List<Shield> listShields(int characterId, boolean canBuy);

	/**
	 * List of weapons wich character able to buy.
	 * 
	 * @param characterId the character Id
	 * @param canBuy <code>true</code> if is the list just contains the weapons wich the character can buy
	 * @return the list of weapons
	 */
	List<Weapon> listWeapons(int characterId, boolean canBuy);

	/**
	 * List of armors wich character able to buy.
	 * 
	 * @param characterId the character Id
	 * @param canBuy <code>true</code> if is the list just contains the armors wich the character can buy
	 * @return the list of armors
	 */
	List<Armor> listArmors(int characterId, boolean canBuy);

	/**
	 * Buy an item for a specific character.
	 * 
	 * @param type the type of the item
	 * @param itemId the ID of the item
	 * @param characterId the character ID
	 */
	void buy(ItemType type, Integer itemId, Integer characterId);

	/**
	 * Find armor by ID.
	 * 
	 * @param id the armor id
	 * @return the armor or <code>null</code>
	 */
	Armor findArmorById(Integer id);

	/**
	 * Find shield by Id.
	 * 
	 * @param id the shield id
	 * @return the shield or <code>null</code>
	 */
	Shield findShieldById(Integer id);

	/**
	 * Find weapon by Id.
	 * 
	 * @param id the weapon id
	 * @return the weapon or <code>null</code>
	 */
	Weapon findWeaponById(Integer id);

}