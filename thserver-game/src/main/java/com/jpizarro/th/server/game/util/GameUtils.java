package com.jpizarro.th.server.game.util;

import java.util.ArrayList;
import java.util.List;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.TeamTO;
import com.jpizarro.th.lib.game.entity.UserTO;
import com.jpizarro.th.server.game.model.entity.Game;
import com.jpizarro.th.server.game.model.entity.Place;
import com.jpizarro.th.server.game.model.entity.Team;
import com.jpizarro.th.server.game.model.entity.User;

public class GameUtils {
	public static GameTO gameTOFromGame(Game game){
		GameTO gameTO = new GameTO();
		gameTO.setGameId(game.getGameId());
		gameTO.setName(game.getName());
		gameTO.setDescription(game.getDescription());
		gameTO.setStartDate( game.getStartDate());
		gameTO.setFinishDate( game.getFinishDate());
		gameTO.setCity( game.getCity());
		int pP = 0, hP = 0, gP = 0;
		for (Place place:game.getPlaces()){
			pP ++;
			if (place.getType().equals("HIN"))
				hP++;
			if (place.getType().equals("GOA"))
				gP++;
		}
		gameTO.setAvailablePlaces( pP);
		gameTO.setAvailableHints( hP);
		gameTO.setAvailableGoals( gP);
		
		gameTO.setCurrentTeams( game.getTeams().size());
		pP = 0;
//		for (Team team:game.getTeams()){
//			pP += team.getUsers().size();
//		}
		gameTO.setCurrentUsers( pP);
//		gameTO.setCurrentMessages( game.getMessages().size());
		
		gameTO.setMaxTeams( game.getMaxTeams());
		gameTO.setMaxUserPerTeam( game.getMaxUserPerTeam());
		
		gameTO.setLatitude( game.getLatitude());
		gameTO.setLongitude( game.getLongitude());
		return gameTO;
	}

	private static TeamTO teamTOFromTeam(Team team){
		TeamTO teamTO = new TeamTO();
		teamTO.setTeamId( team.getTeamId());

		return teamTO;
	}
	
}
