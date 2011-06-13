package com.jpizarro.th.lib.game.entity;

import org.simpleframework.xml.Element;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("hint")
public class HintTO extends PlaceTO{
	@Element(required=false)
	public static final String TYPE = "HIN";

	public HintTO() {
		super();
		// TODO Auto-generated constructor stub
		this.setType(TYPE);
	}

	public HintTO(long placeId) {
		super(placeId);
		// TODO Auto-generated constructor stub
		this.setType(TYPE);
	}
	
}
