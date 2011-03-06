package com.jpizarro.th.server.game.view.web.components.map;

import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.panel.Panel;

public class MapPanel extends Panel {
	
	private static final String GOOGLE_MAPS_API_URL = "http://maps.google.com/maps/api/js?sensor=false";

	public MapPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		add(HeaderContributor.forJavaScript(GOOGLE_MAPS_API_URL));
	}

}
