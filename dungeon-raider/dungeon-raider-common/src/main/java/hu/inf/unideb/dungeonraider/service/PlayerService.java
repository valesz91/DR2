package hu.inf.unideb.dungeonraider.service;

import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;

/**
 * Default interface of player service.
 * 
 * @author FV
 *
 */
public interface PlayerService {

	/**
	 * Create and save a new character.
	 * 
	 * @param health the characters health
	 * @param dexterity the characters dexterity
	 * @param strength the characters strength
	 * @param quickness the characters quickness
	 * @param name the name of the character
	 * @param password the password for the character
	 */
	void createNewCharacter(Integer health, Integer dexterity, Integer strength, Integer quickness, String name, String password);

	/**
	 * Equip item for a chracter.
	 * 
	 * @param type the type of the item
	 * @param itemId the id of the item
	 * @param characterId the characters ID
	 * @return <code>true</code> if the process was successfull unless <code>false</code>, but this function not realy used yet...
	 */
	boolean equipItem(ItemType type, Integer itemId, Integer characterId);

	/**
	 * Find character by ID.
	 * 
	 * @param id the characters ID.
	 * @return the saved playerscharacter or <code>null</code>
	 */
	PlayersCharacter findById(Integer id);

	/**
	 * Find character by name and password.
	 * 
	 * @param name the character name
	 * @param password the password for the character
	 * @return the saved playerscharacter or <code>null</code>
	 */
	PlayersCharacter findByNameAndPassword(String name, String password);

	/**
	 * Calculate all item's weight wich the playerscharacter has.
	 * 
	 * @param id the players character ID
	 * @return the calculated weights of the items
	 */
	Double calculateItemsWeightByCharacter(Integer id);

	/**
	 * Unequip an item by the player character. This item has return to the character's inventory.
	 * 
	 * @param type the type of the item
	 * @param itemId the ID of the item
	 * @param characterId the players character's ID.
	 * @return <code>True</code> if the process was successfull
	 */
	boolean unEquipItem(ItemType type, Integer itemId, Integer characterId);

	/**
	 * Drop a selected item.
	 * 
	 * @param type the item type
	 * @param itemId the item ID
	 * @param characterId the players character's ID
	 * @return <code>True</code> if the process was successfull
	 */
	boolean dropItem(ItemType type, Integer itemId, Integer characterId);

}
