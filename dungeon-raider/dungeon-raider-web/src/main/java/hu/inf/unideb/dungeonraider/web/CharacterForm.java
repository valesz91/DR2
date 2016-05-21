package hu.inf.unideb.dungeonraider.web;

import java.util.List;

import hu.inf.unideb.dungeonraider.domain.Item;
import hu.inf.unideb.dungeonraider.domain.Race;

/**
 * Character form with edit and view the characters public informations.
 * 
 * @author FV
 *
 */
public class CharacterForm {

	private String password;
	private String name;
	private Integer actualExp;
	private Integer strength;
	private Integer dexterity;
	private Integer health;
	private Integer quickness;

	private Integer atk;
	private Integer def;
	private Integer hp;
	private Integer damage;
	private Integer loadCapacity;

	private Integer gold;
	private List<Item> inventory;
	private Race race;
	private Integer exp;
	private Double itemsWeights;

	private Item actualWeapon;
	private Item actualShield;
	private Item actualArmor;

	public Item getActualWeapon() {
		return actualWeapon;
	}

	public void setActualWeapon(Item actualWeapon) {
		this.actualWeapon = actualWeapon;
	}

	public Item getActualShield() {
		return actualShield;
	}

	public void setActualShield(Item actualShield) {
		this.actualShield = actualShield;
	}

	public Item getActualArmor() {
		return actualArmor;
	}

	public void setActualArmor(Item actualArmor) {
		this.actualArmor = actualArmor;
	}

	public Double getItemsWeights() {
		return itemsWeights;
	}

	public void setItemsWeights(Double itemsWeights) {
		this.itemsWeights = itemsWeights;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Integer getAtk() {
		return atk;
	}

	public void setAtk(Integer atk) {
		this.atk = atk;
	}

	public Integer getDef() {
		return def;
	}

	public void setDef(Integer def) {
		this.def = def;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(Integer loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
