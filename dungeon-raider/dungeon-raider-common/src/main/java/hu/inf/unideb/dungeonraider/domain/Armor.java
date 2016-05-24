package hu.inf.unideb.dungeonraider.domain;

import java.io.Serializable;

/**
 * The Armor entity.
 * 
 * @author FV
 *
 */
public class Armor extends Item implements Serializable {

	/** Serial. */
	private static final long serialVersionUID = 1185600407741975517L;
	/** Attack point minus value, provided by the armor. */
	private Integer atkMinus;
	/** Defense point plus value, provided by the armor. */
	private Integer defPlus;
	/** Health point plus value, provided by the armor. */
	private Integer healthPlus;

	// CHECKSTYLE:OFF
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
