package com.jpizarro.th.server.game.view.web.pages.home;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import com.jpizarro.th.server.game.view.web.components.map.osm.MapPanel;
import com.jpizarro.th.server.game.view.web.pages.BasePage;

/**
 * Homepage
 */
public abstract class HomePage extends BasePage {
	
	private static final String JQUERY_URL = "js/jquery-1.3.2.min.js";

	// TODO Add any page properties or variables here
    public HomePage() {
    	super();
    	add(HeaderContributor.forJavaScript(JQUERY_URL));
    	add(new MapPanel("mapPanel"));

        // Add the simplest type of label
//        add(new Label("message", "If you see this message wicket is properly configured and running"));

        // TODO Add your page's components here
    }
    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
//    public HomePage(final PageParameters parameters) {
//    	super(parameters);
//
//        // Add the simplest type of label
////        add(new Label("message", "If you see this message wicket is properly configured and running"));
//
//        // TODO Add your page's components here
//    }
}
