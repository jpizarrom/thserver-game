package com.jpizarro.th.server.game.view.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.game.entity.CreateGameTO;
import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;

@Controller
@RequestMapping("/games")
public class GameController implements GenericController <GameTO, Long>{
	@Autowired
	private GameService gameService;
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}",
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
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
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public GameTO updateEntity(@PathVariable Long id, @RequestBody GameTO entity) {
		// TODO Auto-generated method stub
		try {
			entity.setGameId(id);
			return gameService.update(entity);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value="/")
	public GameTO addEntity(@RequestBody GameTO body) {
		// TODO Auto-generated method stub
		GameTO r = new GameTO();
		try {
			gameService.create(body);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r; 
		}
		return r; 
	}

	public void create(GameTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		
	}

	public GameTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public GameTO update(GameTO entity) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public List<String> findCitiesWithGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public GamesTO findGamesByCity(String city, int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public GamesTO findGamesByLocation(int latitude, int longitude,
			int accurate, int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer countActiveGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer countFinishedGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer countNotFinishedGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public GamesTO findActiveGames(int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public GamesTO findNotFinishedGames(int startIndex, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public TeamsTO findTeamsByGame(Long gameId)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public GenericGameResponseTO takePlace(String username, Long placeId,
			InGameUserInfoTO inGameUserInfoTO)
			throws InstanceNotFoundException, DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	public GenericGameResponseTO startOrContinueGame(Long gameId, Long userId,
			Long teamId) throws InstanceNotFoundException, TimeOutException {
		// TODO Auto-generated method stub
		return null;
	}

	public GameTO createGame(CreateGameTO createGameTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
