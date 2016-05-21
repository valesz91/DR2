package hu.inf.unideb.dungeonraider.dao;

import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;

public interface PlayersCharacterDao {

	/**
	 * Find a player's character by name and password
	 * 
	 * @param name the characters name
	 * @param password the password for this character
	 * @return the Players character os <code>null</code>
	 */
	PlayersCharacter findByNameAndPassword(String name, String password);

	/**
	 * Save or update character.
	 * 
	 * @param character the player's character
	 */
	void saveOrUpdatePlayersCharacter(PlayersCharacter character);

	/**
	 * Delete an existing character.
	 * 
	 * @param character the player's character
	 */
	void deletePlayersCharacter(PlayersCharacter character);

	/**
	 * Find an existing character by id.
	 * 
	 * @param id the id of the saved character entity not <code>null</code>
	 * @return the character or <code>null</code>
	 */
	PlayersCharacter findById(Integer id);

	/**
	 * Find an existing character by name property.
	 *
	 * @param name the characters name
	 * @return the Players character os <code>null</code>
	 */
	PlayersCharacter findByName(String name);

}
