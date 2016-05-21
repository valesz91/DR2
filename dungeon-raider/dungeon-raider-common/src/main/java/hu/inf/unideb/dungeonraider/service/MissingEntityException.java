package hu.inf.unideb.dungeonraider.service;

public class MissingEntityException extends DungeonRaiderException {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6263689859232818566L;
	private final Object id;

	/**
	 * Missing entity exception.
	 * 
	 * @param id the id
	 */
	public MissingEntityException(Object id) {
		this.id = id;
	}

	public Object getId() {
		return id;
	}

}
