package hu.inf.unideb.dungeonraider.web;

import java.util.List;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Item;
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Race;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

public class EditForm {

	private int id;
	private Integer attackPoints;
	private Integer defendPoints;
	private Integer healthPoint;
	private Integer damagePoints;
	private Race race;
	private List<Item> inventory;
	private Integer gold;
	private Weapon actualWeapon;
	private Shield actualShield;
	private Armor actualArmor;
	private String name;
	private Double loadCapacity;
	private Integer actualExp;
	private Integer strength;
	private Integer dexterity;
	private Integer health;
	private Integer quickness;

	private List<Armor> armors;
	private List<Weapon> weapons;
	private List<Shield> shields;
	private List<Potion> potions;

	public Integer getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(Integer attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Integer getDefendPoints() {
		return defendPoints;
	}

	public void setDefendPoints(Integer defendPoints) {
		this.defendPoints = defendPoints;
	}

	public Integer getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(Integer healthPoint) {
		this.healthPoint = healthPoint;
	}

	public Integer getDamagePoints() {
		return damagePoints;
	}

	public void setDamagePoints(Integer damagePoints) {
		this.damagePoints = damagePoints;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Weapon getActualWeapon() {
		return actualWeapon;
	}

	public void setActualWeapon(Weapon actualWeapon) {
		this.actualWeapon = actualWeapon;
	}

	public Shield getActualShield() {
		return actualShield;
	}

	public void setActualShield(Shield actualShield) {
		this.actualShield = actualShield;
	}

	public Armor getActualArmor() {
		return actualArmor;
	}

	public void setActualArmor(Armor actualArmor) {
		this.actualArmor = actualArmor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(Double loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public Integer getActualExp() {
		return actualExp;
	}

	public void setActualExp(Integer actualExp) {
		this.actualExp = actualExp;
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

	public List<Potion> getPotions() {
		return potions;
	}

	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
