package com.jpizarro.th.server.game.view.web.pages.game.details;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
//import org.wicketstuff.annotation.mount.MountPath;
//import org.wicketstuff.annotation.strategy.MountMixedParam;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.game.view.web.application.WicketApplication;
import com.jpizarro.th.server.game.view.web.components.game.details.GameDetailsPanel;
import com.jpizarro.th.server.game.view.web.pages.BasePage;
import com.jpizarro.th.server.game.view.web.pages.home.HomePage;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;

@AuthorizeInstantiation("ROLE_USER")
//@MountPath(path = "gameDetails")
//@MountMixedParam(parameterNames={"gameId"})
public class GameDetailsPage extends HomePage {

	public GameDetailsPage(PageParameters parameters) {
//		super(parameters);
		super();
		long gameId = parameters.getLong("gameId");

		GameService gameService = WicketApplication.get().getGameService();
		try {
			GameTO gameTO = gameService.find(gameId);
			GenericGameResponseTO ggto = gameService.startOrContinueGame(gameId);
			add(new GameDetailsPanel("gameDetails", gameTO, ggto));
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeOutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String getTitle() {
		return getLocalizer().getString("gameDetails.title", GameDetailsPage.this);
	}

}
