package hu.inf.unideb.dungeonraider.service;

public class ItemException extends DungeonRaiderException {

	private static final long serialVersionUID = 1L;

	public ItemException() {
		super();
	}

	public ItemException(String message) {
		super(message);
	}

	public ItemException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemException(Throwable cause) {
		super(cause);

	}
}
