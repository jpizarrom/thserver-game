package com.jpizarro.th.server.game.view.web.pages.home.user;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;

import com.jpizarro.th.server.game.view.web.components.user.menu.MenuPanel;
import com.jpizarro.th.server.game.view.web.pages.home.HomePage;

@MountPath(path = "user/home")
@AuthorizeInstantiation("ROLE_USER")
public class UserHomePage extends HomePage {

	public UserHomePage() {
		super();
		add(new MenuPanel("menuPanel"));
	}

	@Override
	protected String getTitle() {
		return getLocalizer().getString("userHomePage.title", UserHomePage.this);
	}

}
