package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("place")
public class PlaceTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6003312565456112948L;
	
	private long placeId;
	

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

}
