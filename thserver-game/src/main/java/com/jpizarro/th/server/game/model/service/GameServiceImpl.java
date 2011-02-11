package com.jpizarro.th.server.game.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.server.game.model.persistence.accessor.GameAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.PlaceAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.TeamAccessor;
import com.jpizarro.th.server.game.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;

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
	
//	@Autowired
//	private MessageAccessor messageAccessor;

	@Override
	public void create(GameTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameTO update(GameTO entity) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
