package com.jpizarro.th.server.game.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.server.game.model.entity.Game;
import com.jpizarro.th.server.game.model.entity.Place;
import com.jpizarro.th.server.game.model.entity.Team;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GamesTO findGamesByCity(String city, int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GamesTO findGamesByLocation(int latitude, int longitude,
			int accurate, int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countActiveGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countFinishedGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countNotFinishedGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GamesTO findActiveGames(int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GamesTO findNotFinishedGames(int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamsTO findTeamsByGame(long gameId)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericGameResponseTO takePlace(String username, long placeId,
			InGameUserInfoTO inGameUserInfoTO)
			throws InstanceNotFoundException, DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	private GameTO gameTOFromGame(Game game){
		return GameUtils.gameTOFromGame(game);
	
	}

	@Override
	public GenericGameResponseTO startOrContinueGame(String username)
			throws InstanceNotFoundException, TimeOutException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameTO createGame(CreateGameTO createGameTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
