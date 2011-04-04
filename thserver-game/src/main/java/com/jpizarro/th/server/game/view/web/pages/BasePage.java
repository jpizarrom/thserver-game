package com.jpizarro.th.server.game.view.web.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import com.jpizarro.th.server.game.view.web.components.user.details.UserDetailsPanel;
import com.jpizarro.th.server.game.view.web.session.WicketSession;

public abstract class BasePage extends WebPage {
	private static final String CSS_URL = "css/styles.css";

	public BasePage() {
		this(null);
	}

	public BasePage(PageParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
		add(HeaderContributor.forCss(CSS_URL));
		add(new FeedbackPanel("feedback"));

		if (WicketSession.get().isSignedIn()) {
			add(new UserDetailsPanel("loginPanel", WicketSession.get().getLoginResultTO().getUsername()));
		}
		else {
			add(new Label("loginPanel", "loginPanel"));
//			add(new LoginPanel("loginPanel"));
		}
			add(new Label("title", getTitle()));
	}

	protected abstract String getTitle();
	}
