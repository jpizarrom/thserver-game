package com.jpizarro.th.lib.game.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("hint")
public class HintTO extends PlaceTO{
	protected String TYPE = "HINT";

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
