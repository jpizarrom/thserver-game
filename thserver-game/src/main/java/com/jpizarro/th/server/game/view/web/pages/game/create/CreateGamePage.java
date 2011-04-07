package com.jpizarro.th.server.game.view.web.pages.game.create;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.GoalTO;
import com.jpizarro.th.lib.game.entity.HintTO;
import com.jpizarro.th.lib.game.entity.PlaceTO;
import com.jpizarro.th.lib.team.entity.TeamTO;
import com.jpizarro.th.server.game.view.web.application.WicketApplication;
import com.jpizarro.th.server.game.view.web.pages.BasePage;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;

@MountPath(path = "create")
@AuthorizeInstantiation( { "ROLE_USER" })
public class CreateGamePage extends BasePage {

	public CreateGamePage(PageParameters pageParameters) {
		super();
		// TODO Auto-generated constructor stub
		String city = pageParameters.getString("city");
		int latitude = pageParameters.getInt("latitude");
		int longitude = pageParameters.getInt("longitude");
		int maxTeams = pageParameters.getInt("maxTeams");
		int maxUserPerTeam = pageParameters.getInt("maxUserPerTeam");
		int numberOfItems = pageParameters.getInt("numberOfItems");
		
		Set<PlaceTO> items = new HashSet<PlaceTO>();
		for (int i = 1;i <= numberOfItems; i++) {
			String type = pageParameters.getString("type_" + String.valueOf(i));
			PlaceTO placeTO;
			if (type.equals("COI"))
				placeTO = new HintTO();
			else
				placeTO = new GoalTO();
//			
//			placeTO.setPlaceId(pageParameters.getLong("itemId_" + String.valueOf(i)));
//			placeTO.setLatitude(pageParameters.getInt("itemLatitude_" + String.valueOf(i)));
//			placeTO.setLongitude(pageParameters.getInt("itemLongitude_" + String.valueOf(i)));
//			placeTO.setName("name");
//			placeTO.setDescription("description");
			placeTO.setType(type);
			
			//			placeTO.setType("HIN");
//			
			items.add(placeTO);
			
			com.jpizarro.th.lib.place.entity.PlaceTO p;
			p = new com.jpizarro.th.lib.place.entity.PlaceTO(); 
			try {
				p.setLatitude(pageParameters.getInt("itemLatitude_" + String.valueOf(i)));
				p.setLongitude(pageParameters.getInt("itemLongitude_" + String.valueOf(i)));
				p.setName(pageParameters.getString("itemName_" + String.valueOf(i)));
				p.setDescription(pageParameters.getString("itemDescription_" + String.valueOf(i)));
				
				p = WicketApplication.get().getPlaceService().create(p);
				System.out.println(p.getPlaceId());
			} catch (DuplicateInstanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		TeamTO t;
		for (int i = 0; i< maxTeams;i++){
			try {
				t = new TeamTO();
				WicketApplication.get().getTeamService().create(t);
			} catch (DuplicateInstanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		CreateGameTO createGameTO = new CreateGameTO();
		createGameTO.setCity(city);
		createGameTO.setFinishDate(Calendar.getInstance());
		createGameTO.setStartDate(Calendar.getInstance());
		createGameTO.setLatitude(latitude);
		createGameTO.setLongitude(longitude);
		createGameTO.setMaxTeams(maxTeams);
		createGameTO.setMaxUserPerTeam(maxUserPerTeam);
		createGameTO.setPlaces(items);
		
		GameTO gameTO;
		try {
			gameTO = WicketApplication.get().getGameService().createGame(createGameTO);
		} catch (DuplicateInstanceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			gameTO = null;
		};
		try {
			this.getResponse().getOutputStream().write(String.valueOf(gameTO.getGameId()).getBytes());
			this.getResponse().getOutputStream().close();
		} catch(IOException e) {
			// TODO
		}
	}

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
