package com.jpizarro.th.server.game.view.web.components.game.details;

import java.util.Calendar;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.server.game.view.web.pages.game.details.GameDetailsPage;
import com.jpizarro.th.server.game.view.web.session.WicketSession;

public class GameDetailsPanel extends Panel {

	public GameDetailsPanel(String id, final GameTO gameTO) {
		super(id);
		// TODO Auto-generated constructor stub
		add(new Label("name", gameTO.getName()));
		add(new Label("city", gameTO.getCity()));
		add(new Label("description", gameTO.getDescription()));
//		add(new Label("description", gameTO.));
		add(new Label("maxUsers", String.valueOf(gameTO.getMaxUserPerTeam()*gameTO.getMaxTeams())));
		WebMarkupContainer holder = new WebMarkupContainer("currentUsersHolder") {
			
			@Override
			public boolean isVisible() {
////				Calendar now = Calendar.getInstance();
////				return gameTO.getStartDate().before(now) && gameTO.getFinishDate().after(now);
				return true;
			}
		};
		holder.add(new Label("currentUsers", String.valueOf(gameTO.getCurrentUsers())));
		add(holder);
		
//		WebMarkupContainer currentlyActiveContainer = new WebMarkupContainer("currentlyActiveDiv") {
//			
//			@Override
//			public boolean isVisible() {
//				
//				Calendar now = Calendar.getInstance();
////				return gameTO.getStartDate().before(now) && ( gameTO.getFinishDate()==null || gameTO.getFinishDate().after(now));
//				return WicketSession.get().getRoles().hasRole("ROLE_USER");
//			}
//        };
//        PageParameters linkParameters = new PageParameters();
//        linkParameters.put("gameId", new Long(gameTO.getGameId()));
////        currentlyActiveContainer.add(new BookmarkablePageLink("gameDetailsPageLink", GameDetailsPage.class, linkParameters)
////        .add(new Label("gameDetailsPageLinkText", getLocalizer().getString("gameDetails.details", GameDetailsPanel.this))));
//        
//        add(currentlyActiveContainer);
//        
	}

	public GameDetailsPanel(String id, GameTO gameTO,
			GenericGameResponseTO ggto) {
		super(id);
		
		add(new Label("name", gameTO.getName()));
		add(new Label("city", gameTO.getCity()));
		add(new Label("description", gameTO.getDescription()));
		add(new Label("ishasfinished", String.valueOf(ggto.isHasFinished())));
		add(new Label("maxUsers", String.valueOf(gameTO.getMaxUserPerTeam()*gameTO.getMaxTeams())));
		WebMarkupContainer holder = new WebMarkupContainer("currentUsersHolder") {
			
			@Override
			public boolean isVisible() {
////				Calendar now = Calendar.getInstance();
////				return gameTO.getStartDate().before(now) && gameTO.getFinishDate().after(now);
				return true;
			}
		};
		holder.add(new Label("currentUsers", String.valueOf(gameTO.getCurrentUsers())));
		add(holder);
		
	}

}
