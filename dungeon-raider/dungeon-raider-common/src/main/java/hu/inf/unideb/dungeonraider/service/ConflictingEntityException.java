package hu.inf.unideb.dungeonraider.service;

import java.util.Arrays;
import java.util.Collection;

public class ConflictingEntityException extends DungeonRaiderException {

	/** Serial */
	private static final long serialVersionUID = 7651544944892404946L;

	/** Collection of conflicting property names */
	private Collection<String> propertyNames;

	/**
	 * Conflicting entity exception.
	 * 
	 * @param propertyNames the collection of conflicting property names
	 */
	public ConflictingEntityException(Collection<String> propertyNames) {
		this.propertyNames = propertyNames;
	}

	/**
	 * Conflicting entity exception.
	 * 
	 * @param propertyName the conflicting property name
	 */
	public ConflictingEntityException(String propertyName) {
		propertyNames = Arrays.asList(propertyName);
	}

	/**
	 * @returnt he collection of conflicting property names
	 */
	public Collection<String> getPropertyNames() {
		return propertyNames;
	}
}
