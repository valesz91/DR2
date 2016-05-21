package hu.inf.unideb.dungeonraider.domain;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -1123293169831934855L;
	private Integer id;
	private Integer value;
	private Double weight;
	private String name;
	private ItemType type;
	private String description;
	private List<PlayersCharacter> playersCharacter;

	public List<PlayersCharacter> getPlayersCharacter() {
		return playersCharacter;
	}

	public void setPlayersCharacter(List<PlayersCharacter> playersCharacter) {
		this.playersCharacter = playersCharacter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
