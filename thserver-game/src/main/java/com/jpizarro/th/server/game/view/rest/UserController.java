package com.jpizarro.th.server.game.view.rest;

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
import com.jpizarro.th.lib.game.entity.list.CitiesTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.lib.game.entity.UserTO;
import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.game.model.service.UserService;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.user.view.rest.client.UserRestClient;
//import com.jpizarro.th.lib.game.util.GameRestURL;
import com.jpizarro.th.lib.game.util.UserRestURL;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;

@Controller
@RequestMapping(UserRestURL.ENTITY)
public class UserController implements GenericController <UserTO, Long>{
	@Autowired
	private UserService userService;
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURL.ENTITY_ID,
			headers="Accept=application/xml")
	@ResponseBody
	public UserTO getEntity(@PathVariable Long id) {
		UserTO to = null;
		try {
			to = userService.find(id);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"object", to);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=UserRestURL.ENTITY_ID)
	public ModelAndView removeEntity(@PathVariable Long id) {
		boolean ret = true;
		try {
			userService.remove(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = false;
		}
		
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"user", ret);
	}

	@Override
	public List<UserTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value=UserRestURL.ENTITY_ID)
	@ResponseBody
	public UserTO updateEntity(@PathVariable Long id, @RequestBody UserTO entity) {
//		entity.setGameId(id);
//		try {
//			return gameService.update(entity);
//		} catch (InstanceNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}

//	@Override
	@RequestMapping(method=RequestMethod.POST)
//	@ResponseBody
	public UserTO addEntity(@RequestBody UserTO body) {
		// TODO Auto-generated method stub
		UserTO r = null;
//		try {
//			r = gameService.create(body);
//		} catch (DuplicateInstanceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return r; 
	}
}
