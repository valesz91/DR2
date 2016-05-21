package hu.inf.unideb.dungeonraider.service;

public class DungeonRaiderException extends RuntimeException {

	/** Serial number */
	private static final long serialVersionUID = -6131976788085938189L;

	public DungeonRaiderException() {
		super();
	}

	public DungeonRaiderException(String message) {
		super(message);
	}

	public DungeonRaiderException(String message, Throwable cause) {
		super(message, cause);
	}

	public DungeonRaiderException(Throwable cause) {
		super(cause);
	}

}
