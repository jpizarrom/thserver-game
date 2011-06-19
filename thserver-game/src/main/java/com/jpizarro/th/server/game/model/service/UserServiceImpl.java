package com.jpizarro.th.server.game.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.game.entity.TeamTO;
import com.jpizarro.th.lib.game.entity.UserTO;
import com.jpizarro.th.lib.game.entity.list.GameCTO;
import com.jpizarro.th.server.game.model.entity.Game;
import com.jpizarro.th.server.game.model.entity.User;
import com.jpizarro.th.server.game.model.persistence.accessor.GameAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.game.util.GameUtils;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.view.rest.client.TeamRestClient;

@Service(value="GameUserServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserAccessor userAccessor;
	
	@Autowired
	private TeamRestClient teamRestClient;

	@Autowired
	private GameAccessor gameAccessor;
	
	@Override
	public UserTO create(UserTO arg0) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
//		User u = userAccessor.find(id);
		UserTO to = new UserTO();
		to.setUserId(id);
		
		com.jpizarro.th.lib.team.entity.UserTO tu = teamRestClient.getEntityUser(id);
		for (com.jpizarro.th.lib.team.entity.TeamTO tto: tu.getTeams()){
			GameCTO gcto = gameAccessor.findByTeam(tto.getTeamId());
			for (Game g : gcto.getGameList()){
				TeamTO t = new TeamTO(); 
				t.setTeamId(tto.getTeamId());
				t.setGameId(g.getGameId());
				to.getTeams().add(t);
				
//				to.setGameId(g.getGameId());
//				to.setTeamId(tto.getTeamId());
			}
		}
		return to;
	}

	@Override
	public void remove(Long arg0) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public UserTO update(UserTO arg0) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
