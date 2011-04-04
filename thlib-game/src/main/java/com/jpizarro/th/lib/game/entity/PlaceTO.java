package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("place")
public class PlaceTO implements Serializable {
	
	private long placeId;
	private String type = new String();
	

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

}
