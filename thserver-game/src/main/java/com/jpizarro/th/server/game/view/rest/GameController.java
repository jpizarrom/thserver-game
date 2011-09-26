package com.jpizarro.th.server.game.view.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.GoalTO;
import com.jpizarro.th.lib.game.entity.HintTO;
import com.jpizarro.th.lib.game.entity.list.CitiesTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.user.view.rest.client.PlaceRestClient;
import com.jpizarro.th.server.user.view.rest.client.TeamRestClient;
import com.jpizarro.th.server.user.view.rest.client.UserRestClient;
import com.jpizarro.th.lib.game.util.GameRestURL;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;

@Controller
@RequestMapping(GameRestURL.ENTITY)
public class GameController implements GenericController <GameTO, Long>{
	@Autowired
	private GameService gameService;
	@Autowired
	private PlaceRestClient placeRestClient;
	
	@Autowired
	private TeamRestClient teamRestClient;
	
	@Autowired
	private UserRestClient userRestClient;
	
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.ENTITY_ID,
			headers="Accept=application/xml")
	@ResponseBody
	public GameTO getEntity(@PathVariable Long id) {
		GameTO to = null;
		try {
			to = gameService.find(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"object", to);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=GameRestURL.ENTITY_ID)
	public ModelAndView removeEntity(@PathVariable Long id) {
		boolean ret = true;
		try {
			gameService.remove(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = false;
		}
		
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"user", ret);
	}

	@Override
	public List<GameTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value=GameRestURL.ENTITY_ID)
	@ResponseBody
	public GameTO updateEntity(@PathVariable Long id, @RequestBody GameTO entity) {
		entity.setGameId(id);
		try {
			return gameService.update(entity);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	@RequestMapping(method=RequestMethod.POST)
//	@ResponseBody
	public GameTO addEntity(@RequestBody GameTO body) {
		// TODO Auto-generated method stub
		GameTO r = null;
		try {
			r = gameService.create(body);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r; 
	}

	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.FIND_CITIES_WITH_GAMES)
	@ResponseBody
	public CitiesTO findCitiesWithGames() {
		// TODO Auto-generated method stub
		return gameService.findCitiesWithGames();
	}

	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.FIND_GAMES_BY_CITY)
	@ResponseBody
	public GamesTO findGamesByCity(@PathVariable String city, 
			@RequestParam(value="startIndex",required=false) Integer startIndex, 
			@RequestParam(value="count",required=false) Integer count) {
		return gameService.findGamesByCity(city, startIndex, count);
	}

	public GamesTO findGamesByLocation(int latitude, int longitude,
			int accurate, int startIndex, int count) {
		// TODO Auto-generated method stub
		return gameService.findGamesByLocation(latitude, longitude, 
				accurate, startIndex, count);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.COUNT_ACTIVE_GAMES)
	@ResponseBody
	public Integer countActiveGames() {
		// TODO Auto-generated method stub
		return gameService.countActiveGames();
	}
	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.COUNT_FINISHED_GAMES)
	@ResponseBody
	public Integer countFinishedGames() {
		// TODO Auto-generated method stub
		return gameService.countFinishedGames();
	}
	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.COUNT_NOTFINISHED_GAMES)
	@ResponseBody
	public Integer countNotFinishedGames() {
		// TODO Auto-generated method stub
		return gameService.countNotFinishedGames();
	}

	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.FIND_ACTIVE_GAMES)
	@ResponseBody
	public GamesTO findActiveGames(
			@RequestParam(value="startIndex",required=false) Integer startIndex, 
			@RequestParam(value="count",required=false) Integer count) {

		return gameService.findActiveGames(startIndex, count);
	}

	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.FIND_NOTFINISHED_GAMES)
	@ResponseBody
	public GamesTO findNotFinishedGames(
			@RequestParam(value="startIndex",required=false) Integer startIndex, 
			@RequestParam(value="count",required=false) Integer count) {
		// TODO Auto-generated method stub
		return gameService.findNotFinishedGames(startIndex, count);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.FIND_FINISHED_GAMES)
	@ResponseBody
	public GamesTO findFinishedGames(
			@RequestParam(value="startIndex",required=false) Integer startIndex, 
			@RequestParam(value="count",required=false) Integer count) {
		// TODO Auto-generated method stub
		return gameService.findFinishedGames(startIndex, count);
	}

	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.FIND_TEAMS_BY_GAME)
	@ResponseBody
	public TeamsTO findTeamsByGame(@PathVariable Long gameId) {
		// TODO Auto-generated method stub
		try {
			return gameService.findTeamsByGame(gameId);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.ENTITY_ID+"/takePlace/{placeId}")
	@ResponseBody
	public GenericGameResponseTO takePlace(
			@PathVariable(value="id") Long gameId, 
			@PathVariable Long placeId,
			@RequestParam(value="userId",required=false) Long userId,
			@RequestParam(value="teamId",required=false) Long teamId
			)
			throws InstanceNotFoundException, DuplicateInstanceException, TimeOutException {
		// TODO Auto-generated method stub
//		InGameUserInfoTO inGamePlayerInfoTO = new InGameUserInfoTO(username, latitude, longitude);
		gameService.takePlace(userId, placeId, teamId, gameId, null);
		return startOrContinueGame(gameId, userId, teamId);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value=GameRestURL.START_OR_CONTINUEGAME_URL)
	@ResponseBody
	public GenericGameResponseTO startOrContinueGame(
			@PathVariable(value="gameId") Long gameId, 
			@RequestParam(value="userId",required=false) Long userId,
			@RequestParam(value="teamId",required=false) Long teamId
			) throws InstanceNotFoundException, TimeOutException {
		
		GenericGameResponseTO ggto = gameService.startOrContinueGame(gameId, userId, teamId);
		
		com.jpizarro.th.lib.team.entity.list.UsersTO users = teamRestClient.getUsersByTeam(teamId);
		
		List<InGameUserInfoTO> inGameUserInfoTOs = new ArrayList<InGameUserInfoTO>();

		// TODO check if user is part of the team

		for (com.jpizarro.th.lib.team.entity.UserTO user: users.getUsers()){
			InGameUserInfoTO in = new InGameUserInfoTO();
//			in.setUsername(String.valueOf(user.getUserId()));
			
			// TODO add lat,lon
			com.jpizarro.th.lib.user.entity.UserTO uu = userRestClient.getEntity(user.getUserId());
			
			in.setUsername( uu.getUsername() );
			in.setLatitude(uu.getLatitude());
			in.setLongitude(uu.getLongitude());
			
			
			inGameUserInfoTOs.add(in);
		}
		
		ggto.setInGameUserInfoTOs(inGameUserInfoTOs);
		
		
		for(HintTO h:ggto.getHints()){
			long pid = h.getPlaceId();
			if (h.getPlaceRefId() > 0)
				pid = h.getPlaceRefId();
			com.jpizarro.th.lib.place.entity.PlaceTO pto = placeRestClient.getEntity(pid);
			
			h.setLatitude(pto.getLatitude());
			h.setLongitude(pto.getLongitude());
			h.setName(pto.getName());
			h.setDescription(pto.getDescription());
		}
		
		for(HintTO h:ggto.getHideHints()){
			long pid = h.getPlaceId();
			if (h.getPlaceRefId() > 0)
				pid = h.getPlaceRefId();
			com.jpizarro.th.lib.place.entity.PlaceTO pto = placeRestClient.getEntity(pid);
			
			h.setLatitude(pto.getLatitude());
			h.setLongitude(pto.getLongitude());
			h.setName(pto.getName());
			h.setDescription(pto.getDescription());
		}
		for(GoalTO h:ggto.getGoals()){
			long pid = h.getPlaceId();
			if (h.getPlaceRefId() > 0)
				pid = h.getPlaceRefId();
			com.jpizarro.th.lib.place.entity.PlaceTO pto = placeRestClient.getEntity(pid);
			
			h.setLatitude(pto.getLatitude());
			h.setLongitude(pto.getLongitude());
			h.setName(pto.getName());
			h.setDescription(pto.getDescription());
		}
		return ggto;
//		return null;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public GameTO createGame(@RequestBody CreateGameTO createGameTO) {
		GameTO g = null;
		try {
			g = gameService.createGame(createGameTO);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}
}
