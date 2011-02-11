package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ubication")
public class Ubication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7491962873324125012L;
	
	private long placeId;
	
	private int latitude;
	private int longitude;

	private String name;
	private String description;
	private String type;

	public Ubication() {
		super();
	}

	public Ubication(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Ubication(long id, int latitude, int longitude, String name,
			String description) {
		super();
		this.placeId = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.description = description;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
