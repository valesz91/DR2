package hu.inf.unideb.dungeonraider.domain;

public class Potion extends Item {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7634093529458677398L;
	private PotionType potionType;
	private Integer atk;
	private Integer def;
	private Integer health;
	private Integer damage;
	private Integer durability;

	public PotionType getPotionType() {
		return potionType;
	}

	public void setPotionType(PotionType potionType) {
		this.potionType = potionType;
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

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getDurability() {
		return durability;
	}

	public void setDurability(Integer durability) {
		this.durability = durability;
	}

}