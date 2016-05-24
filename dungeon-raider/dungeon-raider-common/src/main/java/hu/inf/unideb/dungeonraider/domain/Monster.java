package hu.inf.unideb.dungeonraider.domain;

/**
 * The monster class.
 * 
 * @author FV
 *
 */
public class Monster extends Creature {
	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = -6358274462715950238L;
	/** The experiance points wich the players character earn after defeating this monster. */
	private Integer exp;
	// CHECKSTYLE:OFF

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

}
