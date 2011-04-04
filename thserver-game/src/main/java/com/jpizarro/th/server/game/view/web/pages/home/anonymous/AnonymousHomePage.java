package com.jpizarro.th.server.game.view.web.pages.home.anonymous;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.jpizarro.th.server.game.view.web.pages.home.HomePage;
import com.jpizarro.th.server.game.view.web.pages.user.login.LoginPage;
import com.jpizarro.th.server.game.view.web.pages.user.login.register.RegisterPage;

public class AnonymousHomePage extends HomePage {

	public AnonymousHomePage() {
		super();
		// TODO Auto-generated constructor stub
		add(new BookmarkablePageLink("loginLink", LoginPage.class));
		add(new BookmarkablePageLink("registerLink", RegisterPage.class));
	}

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return getLocalizer().getString("anonymousHomePage.title", AnonymousHomePage.this);
	}

}
