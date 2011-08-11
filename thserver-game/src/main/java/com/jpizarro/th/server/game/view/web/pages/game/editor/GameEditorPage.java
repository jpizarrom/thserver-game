package com.jpizarro.th.server.game.view.web.pages.game.editor;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.collections.MiniMap;
import org.apache.wicket.util.template.TextTemplateHeaderContributor;
//import org.wicketstuff.annotation.mount.MountPath;

import com.jpizarro.th.server.game.view.web.components.map.googlemaps.MapPanel;
import com.jpizarro.th.server.game.view.web.pages.BasePage;

//@MountPath(path = "edit")
@AuthorizeInstantiation( { "ROLE_USER" })
public class GameEditorPage extends BasePage {
	
	private static final String JQUERY_URL = "js/jquery-1.3.2.min.js";
	private static final String GAME_OBJECTS_URL = "js/gameObjects.js";
	private static final String MAP_MANAGER_URL = "js/mapManager.js";

	public GameEditorPage() {
		super();
		// TODO Auto-generated constructor stub
		add(HeaderContributor.forJavaScript(JQUERY_URL));
		
		add(HeaderContributor.forJavaScript(new ResourceReference(
				GameEditorPage.class, MAP_MANAGER_URL)));
		
		add(HeaderContributor.forJavaScript(GAME_OBJECTS_URL));
		
		add(TextTemplateHeaderContributor.forJavaScript(
				GameEditorPage.class, MAP_MANAGER_URL, new Model(
						getVariablesMap())));
		
		add(new MapPanel("mapPanel"));
		
	}

	@Override
	protected String getTitle() {
		return getLocalizer().getString("gameEditor.title", GameEditorPage.this);
	}
	
	private MiniMap getVariablesMap() {
		MiniMap variables = new MiniMap(5);
		HttpServletRequest request = getWebRequestCycle().getWebRequest()
		.getHttpServletRequest();
		String contextPath = request.getContextPath();

		String createURL = request.getScheme() + "://" + request.getServerName()
			+ ":" + String.valueOf(request.getServerPort()) + contextPath
			+ "/create";
		
		String viewURL = request.getScheme() + "://" + request.getServerName()
			+ ":" + String.valueOf(request.getServerPort()) + contextPath
			+ "/gameDetails/";
		
		variables.put("COIN_IMG", contextPath + "/images/coin.png");
		variables.put("QUESTION_IMG", contextPath + "/images/question.png");
		variables.put("BONUS_IMG", contextPath + "/images/bonus.png");
		
		variables.put("CREATE_URL", createURL);
		variables.put("VIEW_URL", viewURL);

		return variables;
		
	}

}
