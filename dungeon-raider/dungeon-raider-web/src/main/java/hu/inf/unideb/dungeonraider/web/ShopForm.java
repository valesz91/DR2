package hu.inf.unideb.dungeonraider.web;

import java.util.List;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

public class ShopForm {

	private List<Armor> armors;
	private List<Shield> shields;
	private List<Weapon> weapons;
	private List<Potion> potions;
	private Integer characterId;

	public Integer getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}

	private Boolean armorCanBuy = false;
	private Boolean weaponCanBuy = false;
	private Boolean shieldCanBuy = false;
	private Boolean potionCanBuy = false;

	private Integer playerId;

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

}
