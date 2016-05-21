package hu.inf.unideb.dungeonraider.domain;

public class Weapon extends Item {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -1768624967790877296L;
	private Integer atk;
	private Integer def;
	private Integer damage;

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

}
