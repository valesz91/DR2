package hu.inf.unideb.dungeonraider.domain;

import java.io.Serializable;
import java.util.List;

public class Creature implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9058531437460699406L;
	private Integer id;
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

	public Double getLoadCapacity() {
		return loadCapacity;
	}

	public void setActualWeapon(Weapon actualWeapon) {
		this.actualWeapon = actualWeapon;
	}

	public void setActualShield(Shield actualShield) {
		this.actualShield = actualShield;
	}

	public void setActualArmor(Armor actualArmor) {
		this.actualArmor = actualArmor;
	}

	public void setLoadCapacity(Double loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	private MapElement position;

	public Weapon getActualWeapon() {
		return actualWeapon;
	}

	public void equipActualWeapon(Weapon actualWeapon) {
		this.actualWeapon = actualWeapon;
		this.attackPoints = attackPoints + actualWeapon.getAtk();
		this.defendPoints = defendPoints + actualWeapon.getDef();
		this.damagePoints = damagePoints + actualWeapon.getDamage();
		this.loadCapacity = loadCapacity - actualWeapon.getWeight();
	}

	public Shield getActualShield() {
		return actualShield;
	}

	public void equipActualShield(Shield actualShield) {
		this.actualShield = actualShield;
		this.attackPoints = attackPoints - actualShield.getAtkMinus();
		this.defendPoints = defendPoints + actualShield.getDefPlus();
		this.loadCapacity = loadCapacity - actualShield.getWeight();

	}

	public Armor getActualArmor() {
		return actualArmor;
	}

	public void equipActualArmor(Armor actualArmor) {
		this.actualArmor = actualArmor;
		this.attackPoints = attackPoints - actualArmor.getAtkMinus();
		this.defendPoints = defendPoints + actualArmor.getDefPlus();
		this.healthPoint = healthPoint + actualArmor.getHealthPlus();
		this.loadCapacity = loadCapacity - actualArmor.getWeight();

	}

	public MapElement getPosition() {
		return position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPosition(MapElement position) {
		this.position = position;
	}

	public Creature() {
		super();
	}

	public Creature(Integer attackPoints, Integer defendPoints, Integer healthPoint, Integer damagePoints, Race race, List<Item> inventory,
			Integer gold, Weapon actualWeapon, String name, boolean isPlayer) {
		super();
		this.attackPoints = attackPoints;
		this.defendPoints = defendPoints;
		this.healthPoint = healthPoint;
		this.damagePoints = damagePoints;
		this.race = race;
		this.inventory = inventory;
		this.gold = gold;
		this.actualWeapon = actualWeapon;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

}
