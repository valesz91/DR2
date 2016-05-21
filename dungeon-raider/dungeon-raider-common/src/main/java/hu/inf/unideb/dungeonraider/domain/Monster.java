package hu.inf.unideb.dungeonraider.domain;

public class Monster extends Creature {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6358274462715950238L;
	private Integer exp;

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

}
