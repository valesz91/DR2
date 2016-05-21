package hu.inf.unideb.dungeonraider.domain;

public class Shield extends Item {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7747218125528856377L;
	private Integer atkMinus;
	private Integer defPlus;

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

}
