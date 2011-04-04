package com.jpizarro.th.server.user.view.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.lib.team.entity.TeamTO;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.NotImplementedException;
//import com.jpizarro.th.server.user.model.entity.User;
//import com.jpizarro.th.server.user.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.team.model.service.TeamService;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;
import com.mysql.jdbc.NotImplemented;
//import com.jpizarro.th.server.user.util.UserUtils;
import com.thoughtworks.xstream.XStream;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRestClient teamRestClient;
	
	@Override
	public TeamTO create(TeamTO arg0) throws DuplicateInstanceException {
		return teamRestClient.addEntity(arg0);
	}

	@Override
	public boolean exists(Long arg0) {
		throw new NotImplementedException();
	}

	@Override
	public TeamTO find(Long arg0) throws InstanceNotFoundException {
		return teamRestClient.getEntity(arg0);
	}

	@Override
	public void remove(Long arg0) throws InstanceNotFoundException {
		teamRestClient.removeEntity(arg0);
	}

	@Override
	public TeamTO update(TeamTO arg0) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return teamRestClient.updateEntity(arg0.getTeamId(), arg0);
	}

	@Override
	public boolean addUser(Long arg0,
			com.jpizarro.th.lib.team.entity.UserTO arg1)
			throws InstanceNotFoundException {
		TeamTO r = teamRestClient.addUser(arg0, arg1.getUserId());
		if (r != null)
			return true;
		return false;
	}

	@Override
	public com.jpizarro.th.lib.team.entity.UserTO findUser(Long arg0)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(Long arg0,
			com.jpizarro.th.lib.team.entity.UserTO arg1)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
