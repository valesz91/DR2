package hu.inf.unideb.dungeonraider.service;

import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;

public interface PlayerService {

	void createNewCharacter(Integer health, Integer dexterity, Integer strength, Integer quickness, String name, String password);

	boolean equipItem(ItemType type, Integer itemId, Integer characterId);

	PlayersCharacter findById(Integer id);

	PlayersCharacter findByNameAndPassword(String name, String password);

	Double calculateItemsWeightByCharacter(Integer id);

	boolean unEquipItem(ItemType type, Integer itemId, Integer characterId);

	boolean dropItem(ItemType type, Integer itemId, Integer characterId);

}
