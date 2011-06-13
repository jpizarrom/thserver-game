package com.jpizarro.th.server.user.view.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.NotImplementedException;
//import com.jpizarro.th.server.user.model.entity.User;
//import com.jpizarro.th.server.user.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;
import com.mysql.jdbc.NotImplemented;
//import com.jpizarro.th.server.user.util.UserUtils;
import com.thoughtworks.xstream.XStream;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRestClient userRestClient;

//	public UserTO find(long userId) throws InstanceNotFoundException {
//		User user = userAccessor.find(userId);
//		System.out.println("IOIO : " + user);
//		UserTO userTO = new UserTO();
//		userTO.setUserId( user.getUserId());
//		userTO.setUsername( user.getUsername());
//		userTO.setPassword( user.getPassword());
////		userTO.set = user.getRole();
////		if (user.getTeam() != null && user.getTeam().getGame()!= null)
////			userTO.setGameId(user.getTeam().getGame().getGameId());
//		
//		userTO.setLatitude( user.getLatitude());
//		userTO.setLongitude( user.getLongitude());
//		
//		return userTO;
//	}

	@Override
	public LoginResultTO login(String username, String password)
			throws InstanceNotFoundException, IncorrectPasswordException {
		// TODO Auto-generated method stub
		LoginResultTO user = userRestClient.login(username, password);;
		return user;
	}

	@Transactional
	public boolean register(UserRegisterTO usernameInfoTO)
			throws DuplicateInstanceException {	
		return userRestClient.register(usernameInfoTO);
		
	}

	@Override
	@Transactional
	public boolean changePassword(String username, String oldPassword,
			String newPassword) throws InstanceNotFoundException,
			IncorrectPasswordException {
		throw new NotImplementedException();
	}

	@Override
	public boolean updatePersonalInfo(String username,
			UpdatePersonalInfoTO updatePersonalInfoTO)
			throws InstanceNotFoundException {
		throw new NotImplementedException();
	}

	@Override
	@Transactional
	public UserTO create(UserTO entity) throws DuplicateInstanceException {
		throw new NotImplementedException();	
	}

	@Override
	public UserTO find(Long id) throws InstanceNotFoundException {
		return userRestClient.getEntity(id);
	}

	@Override
	public boolean exists(Long id) {
		throw new NotImplementedException();
	}

	@Override
	@Transactional
	public UserTO update(UserTO entity) throws InstanceNotFoundException {
		return userRestClient.updateEntity(entity.getUserId(), entity);
	}

	@Override
	@Transactional
	public void remove(Long id) throws InstanceNotFoundException {
		userRestClient.removeEntity(id);
	}

	@Override
	public UserTO findUserByUserName(String username){
		throw new NotImplementedException();
	}

	@Override
	public boolean updateLocation(Long arg0, int arg1, int arg2)
			throws InstanceNotFoundException {
		return userRestClient.updateLocation(arg0, arg1, arg2);
	}

}
