package com.jpizarro.th.lib.game.entity;

import com.jpizarro.th.lib.place.entity.PlaceTO;

public class GoalTO extends PlaceTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9000633209057772261L;

	public GoalTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoalTO(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	public GoalTO(long placeId, int latitude, int longitude, String name,
			String description, String type) {
		super(placeId, latitude, longitude, name, description, type);
		// TODO Auto-generated constructor stub
	}
	public GoalTO(long placeId, int latitude, int longitude, String name,
			String description) {
		super(placeId, latitude, longitude, name, description);
		// TODO Auto-generated constructor stub
	}
	
}
