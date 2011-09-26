package com.jpizarro.th.server.game.view.web.components.map.osm;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.panel.Panel;

public class MapPanel extends Panel {
	
	private static final String MAPS_API_URL = "http://www.openlayers.org/api/OpenLayers.js";
	private static final String MAP_MANAGER_URL = "js/mapManager.js";

	public MapPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		add(HeaderContributor.forJavaScript(MAPS_API_URL));
//    	add(HeaderContributor.forJavaScript(new ResourceReference(MapPanel.class, MAP_MANAGER_URL)));

	}

}
