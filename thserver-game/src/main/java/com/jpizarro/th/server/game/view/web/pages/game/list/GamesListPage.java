package com.jpizarro.th.server.game.view.web.pages.game.list;

import java.util.Iterator;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.server.game.view.web.application.WicketApplication;
import com.jpizarro.th.server.game.view.web.components.game.list.GameListPanel;
import com.jpizarro.th.server.game.view.web.pages.BasePage;
import com.jpizarro.th.server.game.view.web.pages.home.HomePage;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;

//@AuthorizeInstantiation("ROLE_USER")
public class GamesListPage extends HomePage {
	
	private static final int RESULTS_PER_PAGE = 5;
	
	public enum STRATEGY {
		ACTIVE, ALL
	}
	

	public GamesListPage() {
		this(null, STRATEGY.ALL);
		// TODO Auto-generated constructor stub
	}


	public GamesListPage(STRATEGY strategy) {
		this(null, strategy);
		// TODO Auto-generated constructor stub
	}


	public GamesListPage(PageParameters parameters, STRATEGY strategy) {
//		super(parameters);
		super();
		// TODO Auto-generated constructor stub
		add(new GameListPanel("gamesPanel", new GameProvider(strategy), GamesListPage.RESULTS_PER_PAGE));
	}

	@Override
	protected String getTitle() {
		return getLocalizer().getString("gamesList.title", GamesListPage.this);
	}
	
	class GameProvider implements IDataProvider  {
		private Integer resultsCount;
		private STRATEGY strategy;

		public GameProvider(STRATEGY strategy) {
			super();
			// TODO Auto-generated constructor stub
			this.strategy = strategy;
		}

		@Override
		public void detach() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Iterator iterator(int first, int count) {
			switch (this.strategy) {
			default:
				return WicketApplication.get().getGameService()
				.findNotFinishedGames(first, count).getGames().iterator();
			}
		}

		@Override
		public int size() {
			switch (this.strategy) {
			default:
				if (this.resultsCount == null) {
					this.resultsCount = WicketApplication.get().getGameService()
					.countNotFinishedGames();
				}
			}
			
			return this.resultsCount.intValue();
		}

		@Override
		public IModel model(Object object) {
			return new GameModel((GameTO) object);
		}
		
protected class GameModel extends LoadableDetachableModel {
			
			private static final long serialVersionUID = -5423144904529853027L;
			
			private Long id;

			public GameModel(GameTO gameTO) {
				this.id = new Long(gameTO.getGameId());
			}

			protected Object load() {
				try {
					return WicketApplication.get().getGameService().find(this.id.longValue());
				} catch (InstanceNotFoundException e) {
					return null;
				}
			}
		}
		
	}

}
