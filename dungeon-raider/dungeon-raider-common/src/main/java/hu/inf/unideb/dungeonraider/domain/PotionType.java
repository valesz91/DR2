package hu.inf.unideb.dungeonraider.domain;

public enum PotionType {

	MINOR_HEALING_POTION(5), GREATER_HEALING_POTION(10), RECOVER_POTION(20);

	private final int healtPluss;

	private PotionType(int healtPluss) {
		this.healtPluss = healtPluss;
	}

	public int getHealtPluss() {
		return healtPluss;
	}

}
