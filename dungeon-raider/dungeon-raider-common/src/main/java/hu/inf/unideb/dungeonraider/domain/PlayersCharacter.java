package hu.inf.unideb.dungeonraider.domain;

import java.util.List;

public class PlayersCharacter extends Creature {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8352076718627811388L;
	private String password;
	private Integer actualExp;
	private Integer strength;
	private Integer dexterity;
	private Integer health;
	private Integer quickness;

	private List<Armor> armors;
	private List<Weapon> weapons;
	private List<Shield> shields;
	private List<Potion> potions;

	public List<Potion> getPotions() {
		return potions;
	}

	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}

	public List<Armor> getArmors() {
		return armors;
	}

	public void setArmors(List<Armor> armors) {
		this.armors = armors;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public List<Shield> getShields() {
		return shields;
	}

	public void setShields(List<Shield> shields) {
		this.shields = shields;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getQuickness() {
		return quickness;
	}

	public void setQuickness(Integer quickness) {
		this.quickness = quickness;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActualExp() {
		return actualExp;
	}

	public void setActualExp(Integer actualExp) {
		this.actualExp = actualExp;
	}

}
