package hu.inf.unideb.dungeonraider.domain;

import java.io.Serializable;
import java.util.List;

public class MapElement implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -717948960377373293L;
	private Integer id;
	private String description;
	private MapElement east, south, west, north;
	private MapElementType type;
	private List<Item> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MapElement getEast() {
		return east;
	}

	public void setEast(MapElement east) {
		this.east = east;
	}

	public MapElement getSouth() {
		return south;
	}

	public void setSouth(MapElement south) {
		this.south = south;
	}

	public MapElement getWest() {
		return west;
	}

	public void setWest(MapElement west) {
		this.west = west;
	}

	public MapElement getNorth() {
		return north;
	}

	public void setNorth(MapElement north) {
		this.north = north;
	}

	public MapElementType getType() {
		return type;
	}

	public void setType(MapElementType type) {
		this.type = type;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
