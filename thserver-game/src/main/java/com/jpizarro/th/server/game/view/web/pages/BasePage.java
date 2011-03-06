package com.jpizarro.th.server.game.view.web.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

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
		
		add(new Label("title", getTitle()));
	}
	
	protected abstract String getTitle();
}
