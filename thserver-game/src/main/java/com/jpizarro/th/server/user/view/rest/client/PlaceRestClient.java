package com.jpizarro.th.server.user.view.rest.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.lib.team.entity.TeamTO;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.view.rest.GenericController;

@Service
public class PlaceRestClient implements GenericController <PlaceTO, Long> {
	private RestTemplate restTemplate;
	private Credentials credentials;
	
//	private static final String HOST = "http://localhost";
//	private static final String PORT = ":8070";
//	private static final String APPNAME = "/thserver-place/app";
	
	private static final String HOST = "http://thserver-place.cloudfoundry.com";
	private static final String PORT = "";
	private static final String APPNAME = "/app";
	
	private static final String WSNAME = "/places";
	private static final String URL = HOST + PORT + APPNAME+ WSNAME;
	
	private static final String UTLENTITY = URL + "/{id}";

    public PlaceRestClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlaceRestClient(RestTemplate restTemplate, Credentials credentials) {
		super();
		this.restTemplate = restTemplate;
		this.credentials = credentials;
	}

	public PlaceTO getEntity(Long id) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
        return restTemplate.getForObject(UTLENTITY, PlaceTO.class, vars);
    }

	@Override
	public List<PlaceTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaceTO addEntity(PlaceTO body) {
        return restTemplate.postForEntity(URL, body, PlaceTO.class).getBody();

	}

	@Override
	public PlaceTO updateEntity(Long id, PlaceTO body) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
		restTemplate.put(UTLENTITY, body, vars);
		return this.getEntity(id);
	}

	@Override
	public Object removeEntity(Long id) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
        	restTemplate.delete(UTLENTITY, vars);
        return true;
	}
}
