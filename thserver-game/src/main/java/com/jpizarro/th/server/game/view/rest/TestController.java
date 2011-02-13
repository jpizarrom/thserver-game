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
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.list.TeamsTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.user.view.rest.client.UserRestClient;

import es.sonxurxo.androidrunner.model.service.game.util.exception.TimeOutException;

@Controller
@RequestMapping("/test")
public class TestController{
	@Autowired
	private GameService gameService;
	private String XML_VIEW_NAME = "users";
	
	@Autowired
	private UserRestClient userRestClient;
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}",
			headers="Accept=application/xml")
	@ResponseBody
	public UserTO getEntityRest(@PathVariable Long id) {
		return userRestClient.getEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}",
			headers="Accept=application/xml")
	@ResponseBody
	public Object removeEntityRest(@PathVariable Long id) {
		return userRestClient.removeEntity(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/users",
			headers="Accept=application/xml")
	@ResponseBody
	public Object addEntityRest() {
		UserTO to = new UserTO();
		to.setUsername("joteiro");
		return userRestClient.addEntity(to);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	@ResponseBody
	public UserTO updateEntityRest(@PathVariable Long id) {
		UserTO body = new UserTO();
		body.setUserId(id);
		body.setName("juan");
		return userRestClient.updateEntity(id, body);
	}
	
}
