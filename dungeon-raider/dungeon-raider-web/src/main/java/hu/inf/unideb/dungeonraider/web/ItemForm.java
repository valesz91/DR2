package hu.inf.unideb.dungeonraider.web;

import hu.inf.unideb.dungeonraider.domain.ItemType;

/**
 * Item form.
 * 
 * @author FV
 *
 */

public class ItemForm {
	/** Basic item information: id */
	private Integer id;
	/** Basic item information: value */
	private Integer value;
	/** Basic item information: weight */
	private Double weight;
	/** Basic item information: name */
	private String name;
	/** Basic item information: enumeration type of item */
	private ItemType type;
	/** Basic item information: description */
	private String description;

	/** Weapon specific informations: attack points */
	private Integer atk;

	/** Weapon specific informations: defense points */
	private Integer def;

	/** Weapon specific informations: damage */
	private Integer damage;

	/** Armor and shield specific informations: attack points minus */
	private Integer atkMinus;
	/** Armor and shield specific informations: defend points pluss */
	private Integer defPlus;
	/** Armor and shield specific informations: attack point health pluss */
	private Integer healthPlus;

	// CHECKSTYLE:OFF
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

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getAtkMinus() {
		return atkMinus;
	}

	public void setAtkMinus(Integer atkMinus) {
		this.atkMinus = atkMinus;
	}

	public Integer getDefPlus() {
		return defPlus;
	}

	public void setDefPlus(Integer defPlus) {
		this.defPlus = defPlus;
	}

	public Integer getHealthPlus() {
		return healthPlus;
	}

	public void setHealthPlus(Integer healthPlus) {
		this.healthPlus = healthPlus;
	}

	Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
