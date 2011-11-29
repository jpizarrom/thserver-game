package com.jpizarro.th.server.game.view.web.components.game.list;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.server.game.view.web.components.game.details.list.GameDetailsPanel;
import com.jpizarro.th.server.game.view.web.components.paginator.VerticalFancyPaginator;
import com.jpizarro.th.server.game.view.web.pages.game.list.GamesListPage;

public class GameListPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5041868345005517833L;

	public GameListPanel(String id, IDataProvider gameProvider, final int resultsPerPage) {
		super(id);
		// TODO Auto-generated constructor stub
		WebMarkupContainer gameListBox = new WebMarkupContainer("gamesListBox");
		DataView gameList = new DataView("gamesList", gameProvider, resultsPerPage) {

			@Override
			protected void populateItem(Item item) {
				GameTO gameTO = (GameTO)item.getModelObject();

				item.add(new GameDetailsPanel("gameDetails", gameTO));
				
				if (item.getIndex()%2 == 1) {
                	item.add(new SimpleAttributeModifier("class", "gameDetails-alt"));
                }
			}
		};
		
		gameListBox.add(gameList);
		gameListBox.setOutputMarkupId(true);
		add(gameListBox);
		
		VerticalFancyPaginator paginationLinks = new VerticalFancyPaginator("paginationLinks", gameList);
		add(paginationLinks);
		
//		PagingNavigator pager = new PagingNavigator("paginationLinks", gameList);
//        add(pager);
		
//		// No results
//        WebMarkupContainer noResultsDiv = new WebMarkupContainer("noResults");
//        add(noResultsDiv);
//        
//        if (gameList.getDataProvider().size() != 0) {
//            noResultsDiv.setVisible(false);
//        }
	}

}
