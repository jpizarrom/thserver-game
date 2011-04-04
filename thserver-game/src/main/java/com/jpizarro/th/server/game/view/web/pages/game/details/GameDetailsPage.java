package com.jpizarro.th.server.game.view.web.pages.game.details;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.game.view.web.application.WicketApplication;
import com.jpizarro.th.server.game.view.web.components.game.details.GameDetailsPanel;
import com.jpizarro.th.server.game.view.web.pages.BasePage;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;

@AuthorizeInstantiation("ROLE_USER")
@MountPath(path = "gameDetails")
@MountMixedParam(parameterNames={"gameId"})
public class GameDetailsPage extends BasePage {

	public GameDetailsPage(PageParameters parameters) {
		super(parameters);
		long gameId = parameters.getLong("gameId");

		GameService gameService = WicketApplication.get().getGameService();
		try {
			GameTO gameTO = gameService.find(gameId);
			add(new GameDetailsPanel("gameDetails", gameTO));
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String getTitle() {
		return getLocalizer().getString("gameDetails.title", GameDetailsPage.this);
	}

}
