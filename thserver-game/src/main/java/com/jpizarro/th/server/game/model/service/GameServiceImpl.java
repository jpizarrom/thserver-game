package com.jpizarro.th.server.game.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.GoalTO;
import com.jpizarro.th.lib.game.entity.HintTO;
import com.jpizarro.th.lib.game.entity.PlaceTO;
import com.jpizarro.th.lib.game.entity.TeamTO;
import com.jpizarro.th.lib.game.entity.UserTO;
import com.jpizarro.th.lib.game.entity.list.CitiesTO;
import com.jpizarro.th.lib.game.entity.list.GameCTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.server.game.model.entity.Game;
import com.jpizarro.th.server.game.model.entity.Goal;
import com.jpizarro.th.server.game.model.entity.Hint;
import com.jpizarro.th.server.game.model.entity.Place;
import com.jpizarro.th.server.game.model.entity.Team;
import com.jpizarro.th.server.game.model.entity.User;
import com.jpizarro.th.server.game.model.persistence.accessor.GameAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.PlaceAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.TeamAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.game.util.GameUtils;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private UserAccessor userAccessor;
	
	@Autowired
	private GameAccessor gameAccessor;
	
	@Autowired
	private TeamAccessor teamAccessor;
	
	@Autowired
	private PlaceAccessor placeAccessor;
	
	final public int COUNT = 15;

	@Override
	@Transactional
	public GameTO create(GameTO entity) throws DuplicateInstanceException {
		Game g = GameUtils.gameFromGameTO(entity);
		gameAccessor.create(g);
		return GameUtils.gameTOFromGame(g);
	}

	@Override
	public GameTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		Game game = gameAccessor.find(id);
		return this.gameTOFromGame(game);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return gameAccessor.exists(id);
	}

	@Override
	@Transactional
	public GameTO update(GameTO entity) throws InstanceNotFoundException {
		Game g = GameUtils.gameFromGameTO(entity);
		g = gameAccessor.update(g);
		return GameUtils.gameTOFromGame(g);
	}

	@Override
	@Transactional
	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		gameAccessor.remove(id);
	}

	@Override
	public CitiesTO findCitiesWithGames() {
		CitiesTO c = new CitiesTO();
		for (String s :gameAccessor.findCitiesWithGames())
				c.getCities().add(s);
			
		return c;
	}

	@Override
	public GamesTO findGamesByCity(String city, Integer startIndex, Integer count) {
		if (startIndex == null) startIndex = 0;
		if (count == null) count = COUNT;
		
		GameCTO gameCTO = gameAccessor.findNotFinishedByCity(city, 
				startIndex, count);
		List<GameTO> gameTOList = new ArrayList<GameTO>();
		for (Game game:gameCTO.getGameList()) {
			gameTOList.add(gameTOFromGame(game));
		}
		return new GamesTO(gameTOList, gameCTO.isHasMore());
	}

	@Override
	public GamesTO findGamesByLocation(Integer latitude, Integer longitude,
			Integer accurate, Integer startIndex, Integer count) {
		if (startIndex == null) startIndex = 0;
		if (count == null) count = COUNT;
		
		GameCTO gameCTO = gameAccessor.findNotFinishedByLocation(
				latitude, longitude, accurate, startIndex, count);
		List<GameTO> gameTOList = new ArrayList<GameTO>();
		for (Game game:gameCTO.getGameList()) {
			gameTOList.add(gameTOFromGame(game));
		}
		return new GamesTO(gameTOList, gameCTO.isHasMore());
	}

	@Override
	public Integer countActiveGames() {
		return gameAccessor.countActiveGames();
	}

	@Override
	public Integer countFinishedGames() {
		return gameAccessor.countFinishedGames();
	}

	@Override
	public Integer countNotFinishedGames() {
		// TODO Auto-generated method stub
		return gameAccessor.countNotFinishedGames();
	}

	@Override
	public GamesTO findActiveGames(Integer startIndex, Integer count) {
		if (startIndex == null) startIndex = 0;
		if (count == null) count = COUNT;

		GameCTO gameCTO = this.gameAccessor.findActiveGames(startIndex, count);
		GamesTO gameTOList = new GamesTO();
		gameTOList.setHasMore(gameCTO.isHasMore());
		for (Game game:gameCTO.getGameList()) {
			gameTOList.getGames().add(gameTOFromGame(game));
		}
		return gameTOList;
	}

	@Override
	public GamesTO findNotFinishedGames(Integer startIndex, Integer count) {
		if (startIndex == null) startIndex = 0;
		if (count == null) count = COUNT;

		GameCTO gameCTO = this.gameAccessor.findNotFinishedGames(startIndex, count);
		GamesTO gameTOList = new GamesTO();
		gameTOList.setHasMore(gameCTO.isHasMore());
		for (Game game:gameCTO.getGameList()) {
			gameTOList.getGames().add(gameTOFromGame(game));
		}
		return gameTOList;
	}
	
	public GamesTO findFinishedGames(Integer startIndex, Integer count) {
		if (startIndex == null) startIndex = 0;
		if (count == null) count = COUNT;

		GameCTO gameCTO = this.gameAccessor.findFinishedGames(startIndex, count);
		GamesTO gameTOList = new GamesTO();
		gameTOList.setHasMore(gameCTO.isHasMore());
		for (Game game:gameCTO.getGameList()) {
			gameTOList.getGames().add(gameTOFromGame(game));
		}
		return gameTOList;
	}

	@Override
	public TeamsTO findTeamsByGame(Long gameId)
			throws InstanceNotFoundException {
		Game g = gameAccessor.find(gameId);
		List<TeamTO> teams = new ArrayList<TeamTO>();
		TeamsTO teamsTO = new TeamsTO();
		
		for ( Team t:g.getTeams()){
			TeamTO to = teamTOFromTeam(t);
			teams.add(to);
		}
		teamsTO.setTeams(teams);
		return teamsTO;
	}

	@Override
	@Transactional
	public GenericGameResponseTO takePlace(Long userId, Long placeId, Long teamId, Long gameId, 
			InGameUserInfoTO inGameUserInfoTO)
			throws InstanceNotFoundException, DuplicateInstanceException {

		Place place = placeAccessor.find( placeId );
		User user = userAccessor.find(userId);
		Team team = teamAccessor.find(teamId);
		Game game = gameAccessor.find(gameId);
		GenericGameResponseTO ggrTO = new GenericGameResponseTO();
		
		if(game.isFinished()){
			ggrTO.setHasFinished(true);
			return ggrTO;
		}
		
		boolean getsThePlace = true; //user.getPlacesICanSee().contains(place);
		if (getsThePlace) {
			if ( place.getType().endsWith("GOA")  ){
				game.setFinished(true);
				ggrTO.setHasFinished(true);
			}
//			user.getPlacesICanSee().remove(place);
			team.getPlacesIHave().add(place);
			place.getTeamsHaveMe().add(team);
		}
		
		return ggrTO;
	}

	@Override
	@Transactional
	public GenericGameResponseTO startOrContinueGame(Long gameId, Long userId, Long teamId)
			throws InstanceNotFoundException, TimeOutException {
		Game game = gameAccessor.find(gameId);
//		User user = userAccessor.find(userId);
		Team team = teamAccessor.find(teamId);
		GenericGameResponseTO ggrTO = new GenericGameResponseTO();
//		Game game = team.getGame();
		
		if (!game.isFinished() ) {
			// Places
			getInGamePlaces(ggrTO, game, null, team);
		}else{
			ggrTO.setHasFinished(true);
		}
		
		return ggrTO;
	}
	private void getInGamePlaces(GenericGameResponseTO ggrTO, Game game, User user, Team team) {
		// TODO Auto-generated method stub
		// Places of the team 
//		Team team = user.getTeam();
//		Game game = team.getGame();
		
		List<HintTO> hints = new ArrayList<HintTO>();
		for( Place p: team.getPlacesIHave() ){
			if( p instanceof Hint ){
				HintTO h = new HintTO();
				h.setPlaceId(p.getPlaceId());
//				HintTO h = new HintTO(p.getPlaceId(),
////						p.getLatitude(),
////						p.getLongitude(),
////						p.getName(),
////						p.getDescription(),
//						p.getType());
				hints.add(h);
			}
//				else{
//				ggrTO.setGoalTO(new GoalTO(p));
//			}
		}
		ggrTO.setHints(hints);
		
//		// user see places
//		List<HintTO> userSeeHints = new ArrayList<HintTO>();
//		for( Place p: user.getPlacesICanSee() ){
//			if( p.getType().endsWith("HIN") ){
////				HintTO h = new HintTO(p.getPlaceId(),
////						p.getLatitude(),
////						p.getLongitude(),
////						p.getName(),
////						p.getDescription(),
////						p.getType());
////				userSeeHints.add(h);
//			}
//		}
//		ggrTO.setUserSeeHintTOList(userSeeHints);
		
		// team see places
		List<HintTO> teamSeeHints = new ArrayList<HintTO>();
		for( Place p: team.getPlacesICanSee() ){
			if( p.getType().endsWith("HIN") ){
//				HintTO h = new HintTO(p.getPlaceId(),
//						p.getLatitude(),
//						p.getLongitude(),
//						p.getName(),
//						p.getDescription(),
//						p.getType());
//				teamSeeHints.add(h);
			}
		}
		ggrTO.setTeamSeeHintTOList(teamSeeHints);
		
		// Rest of Places
		List<HintTO> hideHints = new ArrayList<HintTO>();
		for( Place p: game.getPlaces() ){
			if( p.getType().endsWith("HIN") 
					&& !team.getPlacesIHave().contains(p)
					&& p.getTeamsHaveMe().size() == 0 
					&& p.getTeamsCanSeeMe().size() == 0 
					&& p.getUsersCanSeeMe().size() == 0
					){
				HintTO h = new HintTO();
				h.setPlaceId(p.getPlaceId());
//				h.setLatitude(1);
//				HintTO h = new HintTO(p.getPlaceId(),
//						p.getLatitude(),
//						p.getLongitude(),
//						p.getName(),
//						p.getDescription(),
//						p.getType());
				hideHints.add(h);
			} if ( p.getType().endsWith("GOA") ){
				GoalTO goal = new GoalTO();
				goal.setPlaceId(p.getPlaceId());
//				GoalTO goal = new GoalTO(p.getPlaceId(),
//						p.getLatitude(),
//						p.getLongitude(),
//						p.getName(),
//						p.getDescription(),
//						p.getType());
//				ggrTO.setGoal(goal);
				ggrTO.getGoals().add(goal);
			}
		}
		ggrTO.setHideHints(hideHints);
		
	}

	@Override
	@Transactional
	public GameTO createGame(CreateGameTO createGameTO) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		Game g = GameUtils.createGameFromGameTO(createGameTO);
		gameAccessor.create(g);
		Set<Place> places = new HashSet<Place>();
		for (PlaceTO itemTO : createGameTO.getPlaces()) {
			Place p = null;
			if (itemTO.getType().equals("HIN"))
				 p = new Hint();
			else
				 p = new Goal();
			p.setType(itemTO.getType());
			p.setGame(g);
			this.placeAccessor.create(p);
		}
		for (int i = 0;i < g.getMaxTeams();i++) {
			Team t  = new Team();
			t.setGame(g);
			this.teamAccessor.create(t);
		}

		
		try {
			g = this.gameAccessor.find(g.getGameId());
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GameUtils.gameTOFromGame(g);
	}

	private GameTO gameTOFromGame(Game game){
		return GameUtils.gameTOFromGame(game);
	}
	private TeamTO teamTOFromTeam(Team team){
		return GameUtils.teamTOFromTeam(team);
	}

	@Override
	public boolean addHint(Long gameId, PlaceTO to)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TeamTO> getTeams(Long gameId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserTO findUser(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		User u = userAccessor.find(id);
		return GameUtils.userTOFromUser(u);
	}

	@Override
	public GamesTO findGamesByTeam(Long id) {
		// TODO Auto-generated method stub
//		gameAccessor.
		return null;
	}

}
