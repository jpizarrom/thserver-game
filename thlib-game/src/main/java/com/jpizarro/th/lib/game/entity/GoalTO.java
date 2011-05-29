package com.jpizarro.th.lib.game.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("goal")
public class GoalTO extends PlaceTO {
	protected String TYPE = "GOAL";

	public GoalTO() {
		super();
		// TODO Auto-generated constructor stub
		this.setType(TYPE);
	}

	public GoalTO(long placeId) {
		super(placeId);
		// TODO Auto-generated constructor stub
		this.setType(TYPE);
	}
	
	
}
