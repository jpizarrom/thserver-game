package com.jpizarro.th.server.user.view.rest.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jpizarro.th.lib.user.entity.UserTO;

@Service
public class UserRestClient {
	private RestTemplate restTemplate;
	private Credentials credentials;
	
	private static final String HOST = "http://localhost";
	private static final String PORT = ":8071";
	private static final String APPNAME = "/thserver-user/app";
	private static final String WSNAME = "/users";
	private static final String URL = HOST + PORT + APPNAME+ WSNAME;
	
	private static final String getEntity = URL + "/{id}";
	private static final String mPost = "https://twitter.com/statuses/update.xml";

    public UserRestClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRestClient(RestTemplate restTemplate, Credentials credentials) {
		super();
		this.restTemplate = restTemplate;
		this.credentials = credentials;
	}

	public UserTO getEntity(Long id) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
        return restTemplate.getForObject(getEntity, UserTO.class, vars);
    }
}
