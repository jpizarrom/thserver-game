package com.jpizarro.th.server.game.view.web.components.user.details;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.jpizarro.th.server.game.view.web.application.WicketApplication;
import com.jpizarro.th.server.game.view.web.session.WicketSession;

public class UserDetailsPanel extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2469138314488437609L;
	public UserDetailsPanel(String id, String username) {
		super(id);
		this.add(new Label("login", username));

	}


}
