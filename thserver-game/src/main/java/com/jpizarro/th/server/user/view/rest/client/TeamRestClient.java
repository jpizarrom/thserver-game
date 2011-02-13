package com.jpizarro.th.server.user.view.rest.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jpizarro.th.lib.team.entity.TeamTO;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.view.rest.GenericController;

@Service
public class TeamRestClient implements GenericController <TeamTO, Long> {
	private RestTemplate restTemplate;
	private Credentials credentials;
	
	private static final String HOST = "http://localhost";
	private static final String PORT = ":8072";
	private static final String APPNAME = "/thserver-team/app";
	private static final String WSNAME = "/teams";
	private static final String URL = HOST + PORT + APPNAME+ WSNAME;
	
	private static final String UTLENTITY = URL + "/{id}";

    public TeamRestClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamRestClient(RestTemplate restTemplate, Credentials credentials) {
		super();
		this.restTemplate = restTemplate;
		this.credentials = credentials;
	}

	public TeamTO getEntity(Long id) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
        return restTemplate.getForObject(UTLENTITY, TeamTO.class, vars);
    }

	@Override
	public List<TeamTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamTO addEntity(TeamTO body) {
        Map<String, String> vars = new HashMap<String, String>();
        return restTemplate.postForEntity(URL, body, TeamTO.class).getBody();

	}

	@Override
	public TeamTO updateEntity(Long id, TeamTO body) {
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
