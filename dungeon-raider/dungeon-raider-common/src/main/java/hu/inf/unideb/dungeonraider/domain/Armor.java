package hu.inf.unideb.dungeonraider.domain;

import java.io.Serializable;

public class Armor extends Item implements Serializable {

	/** Serial */
	private static final long serialVersionUID = 1185600407741975517L;
	private Integer atkMinus;
	private Integer defPlus;
	private Integer healthPlus;

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

}
