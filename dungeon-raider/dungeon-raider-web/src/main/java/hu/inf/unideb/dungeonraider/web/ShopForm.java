package hu.inf.unideb.dungeonraider.web;

import java.util.List;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

/**
 * Form entity for shop wiews.
 * 
 * @author FV
 *
 */
public class ShopForm {

	/** List of all armors. */
	private List<Armor> armors;
	/** List of all shield. */

	private List<Shield> shields;
	/** List of all weapons. */

	private List<Weapon> weapons;
	/** List of all potions. */

	private List<Potion> potions;

	/** Selector for show only armors wich for the players character has enoug money. */
	private Boolean armorCanBuy = false;
	/** Selector for show only weapons wich for the players character has enoug money. */

	private Boolean weaponCanBuy = false;
	/** Selector for show only shields wich for the players character has enoug money. */

	private Boolean shieldCanBuy = false;
	/** Selector for show only potionss wich for the players character has enoug money. */

	private Boolean potionCanBuy = false;

	/** The player ID. */
	private Integer playerId;
	/** Unused id. Occures problems on the shop layout, so it was disabled. */
	private Integer characterId;

	private Integer gold;
	private Double loadCapacity;

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Double getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(Double loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	// CHECKSTYLE:OFF
	public Integer getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}

	public List<Potion> getPotions() {
		return potions;
	}

	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}

	public Boolean getArmorCanBuy() {
		return armorCanBuy;
	}

	public void setArmorCanBuy(Boolean armorCanBuy) {
		this.armorCanBuy = armorCanBuy;
	}

	public Boolean getWeaponCanBuy() {
		return weaponCanBuy;
	}

	public void setWeaponCanBuy(Boolean weaponCanBuy) {
		this.weaponCanBuy = weaponCanBuy;
	}

	public Boolean getShieldCanBuy() {
		return shieldCanBuy;
	}

	public void setShieldCanBuy(Boolean shieldCanBuy) {
		this.shieldCanBuy = shieldCanBuy;
	}

	public Boolean getPotionCanBuy() {
		return potionCanBuy;
	}

	public void setPotionCanBuy(Boolean potionCanBuy) {
		this.potionCanBuy = potionCanBuy;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public List<Armor> getArmors() {
		return armors;
	}

	public void setArmors(List<Armor> armors) {
		this.armors = armors;
	}

	public List<Shield> getShields() {
		return shields;
	}

	public void setShields(List<Shield> shields) {
		this.shields = shields;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	// CHECKSTYLE:ON

}
