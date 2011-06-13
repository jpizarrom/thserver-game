package com.jpizarro.th.lib.game.entity;

import org.simpleframework.xml.Element;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("goal")
public class GoalTO extends PlaceTO {
	@Element(required=false)
	public static final String TYPE = "GOA";

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
