package com.jpizarro.th.server.game.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.TeamTO;
import com.jpizarro.th.lib.game.entity.list.GameCTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.server.game.model.entity.Game;
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

	@Override
	public void create(GameTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		
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
	public GameTO update(GameTO entity) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		gameAccessor.remove(id);
		
	}

	@Override
	public List<String> findCitiesWithGames() {
		return gameAccessor.findCitiesWithGames();
	}

	@Override
	public GamesTO findGamesByCity(String city, Integer startIndex, Integer count) {
		if (startIndex == null) startIndex = 0;
		if (count == null) count = 5;
		
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
		if (count == null) count = 5;
		
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
		if (count == null) count = 5;

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
		if (count == null) count = 5;

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
		if (count == null) count = 5;

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
	public GenericGameResponseTO takePlace(String username, Long placeId,
			InGameUserInfoTO inGameUserInfoTO)
			throws InstanceNotFoundException, DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericGameResponseTO startOrContinueGame(Long gameId, Long userId, Long teamId)
			throws InstanceNotFoundException, TimeOutException {
		User user = userAccessor.find(userId);
		Team team = teamAccessor.find(teamId);
		GenericGameResponseTO ggrTO = new GenericGameResponseTO();
		Game game = team.getGame();
		
		if (!game.isFinished() ) {		
		}
		
		return ggrTO;
	}

	@Override
	public GameTO createGame(CreateGameTO createGameTO) {
		// TODO Auto-generated method stub
		return null;
	}

	private GameTO gameTOFromGame(Game game){
		return GameUtils.gameTOFromGame(game);
	}
	private TeamTO teamTOFromTeam(Team team){
		return GameUtils.teamTOFromTeam(team);
	}

}
