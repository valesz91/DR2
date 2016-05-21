package hu.inf.unideb.dungeonraider.service;

import java.util.List;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

public interface ItemService {

	List<Potion> listPotions(int characterId, boolean canBuy);

	List<Shield> listShields(int characterId, boolean canBuy);

	List<Weapon> listWeapons(int characterId, boolean canBuy);

	List<Armor> listArmors(int characterId, boolean canBuy);

	void buy(ItemType type, Integer itemId, Integer characterId);

}