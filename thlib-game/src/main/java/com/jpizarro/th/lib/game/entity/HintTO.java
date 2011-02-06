package com.jpizarro.th.lib.game.entity;

import com.jpizarro.th.lib.place.entity.PlaceTO;

public class HintTO extends PlaceTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2597865271165158366L;

	public HintTO(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public HintTO(long id, int latitude, int longitude, String name,
			String description) {
		super(id, latitude, longitude, name, description);
		// TODO Auto-generated constructor stub
	}

	public HintTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HintTO(long placeId, int latitude, int longitude, String name,
			String description, String type) {
		super(placeId, latitude, longitude, name, description, type);
		// TODO Auto-generated constructor stub
	}

}
