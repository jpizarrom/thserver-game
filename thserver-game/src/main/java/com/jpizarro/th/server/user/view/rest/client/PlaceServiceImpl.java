package com.jpizarro.th.server.user.view.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.NotImplementedException;
import com.jpizarro.th.server.place.model.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	private PlaceRestClient placeRestClient;

	@Override
	public PlaceTO create(PlaceTO arg0) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return placeRestClient.addEntity(arg0);
	}

	@Override
	public boolean exists(Long arg0) {
		throw new NotImplementedException();
	}

	@Override
	public PlaceTO find(Long arg0) throws InstanceNotFoundException {
		return placeRestClient.getEntity(arg0);
	}

	@Override
	public void remove(Long arg0) throws InstanceNotFoundException {
		placeRestClient.removeEntity(arg0);		
	}

	@Override
	public PlaceTO update(PlaceTO arg0) throws InstanceNotFoundException {
		return placeRestClient.updateEntity(arg0.getPlaceId(), arg0);
	}

}
