package com.jpizarro.th.server.game.view.web.components.user.login;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import com.jpizarro.th.server.game.view.web.pages.user.login.LoginPage;

public class LoginPanel extends Panel {

	public LoginPanel(String id) {
		super(id);
		this.add(new BookmarkablePageLink("loginLink", LoginPage.class));
	}

}
