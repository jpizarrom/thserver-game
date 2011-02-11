package com.jpizarro.th.server.game.model.service;

import java.util.List;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.model.service.GenericService;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;


public interface GameService extends GenericService <GameTO, Long>{
	
	public List<String> findCitiesWithGames();
	
	public GamesTO findGamesByCity(String city, Integer startIndex, Integer count);
	
	public GamesTO findGamesByLocation(Integer latitude, Integer longitude, Integer accurate, 
			Integer startIndex, Integer count);
	
	public Integer countActiveGames();
	
	public Integer countFinishedGames();
	
	public Integer countNotFinishedGames();
	
	public GamesTO findActiveGames(Integer startIndex, Integer count);
	
	public GamesTO findNotFinishedGames(Integer startIndex, Integer count);
	
	public GamesTO findFinishedGames(Integer startIndex, Integer count);
	
	public TeamsTO findTeamsByGame(Long gameId) throws InstanceNotFoundException;
	
	public GenericGameResponseTO takePlace(String username, Long placeId, 
			InGameUserInfoTO inGameUserInfoTO)
	throws InstanceNotFoundException, DuplicateInstanceException;
	
	public GenericGameResponseTO startOrContinueGame(Long gameId, Long userId, Long teamId)
	throws InstanceNotFoundException, TimeOutException;
	
	public GameTO createGame(CreateGameTO createGameTO);
	
}
