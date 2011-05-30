package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("place")
@Root
public class PlaceTO implements Serializable {
	
	@Element(required=false)
	private long placeId;
	
	@Element(required=false)
	private String type = new String();
	
	@Element(required=false)
	private int latitude;
	
	@Element(required=false)
	private int longitude;
	
	@Element(required=false)
	private String name;
	
	@Element(required=false)
	private String description;
	

	public PlaceTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlaceTO(long placeId) {
		super();
		this.placeId = placeId;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
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

}
