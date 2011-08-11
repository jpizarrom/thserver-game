package com.jpizarro.th.server.user.view.rest.client;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.lib.user.util.UserRestURL;
import com.jpizarro.th.server.generic.view.rest.GenericController;

@Service
public class UserRestClient implements GenericController <UserTO, Long> {
	private RestTemplate restTemplate;
	private Credentials credentials;
	
//	private static final String HOST = "http://localhost";
//	private static final String PORT = ":8070";
//	private static final String APPNAME = "/thserver-user/app";
	
	private static final String HOST = "http://thserver-user.cloudfoundry.com";
	private static final String PORT = "";
	private static final String APPNAME = "/app";
	
	private static final String WSNAME = "/users";
	private static final String URL = HOST + PORT + APPNAME+ WSNAME;
	
	private static final String UTLENTITY = URL + "/{id}";

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
        return restTemplate.getForObject(UTLENTITY, UserTO.class, vars);
    }
	public UserTO getEntity(String username) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("username", username);
        return restTemplate.getForObject(URL+UserRestURL.FIND_USER_BY_USERNAME, UserTO.class, vars);
    }

	@Override
	public List<UserTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTO addEntity(UserTO body) {
        Map<String, String> vars = new HashMap<String, String>();
        return restTemplate.postForEntity(URL, body, UserTO.class).getBody();

	}

	@Override
	public UserTO updateEntity(Long id, UserTO body) {
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
	
	public LoginResultTO login(
			String username, 
			String password
			){
		URI url;
		Map<String, String> vars = new HashMap<String, String>();
        vars.put("username", username);
        vars.put("password", password);
        return restTemplate.getForObject(URL + UserRestURL.LOGIN+"?username={username}&password={password}", LoginResultTO.class, vars);
	}
	public boolean register(UserRegisterTO body) {
        Map<String, String> vars = new HashMap<String, String>();
        return restTemplate.postForEntity(URL+UserRestURL.REGISTER, body, Boolean.class).getBody();

	}
	public boolean updateLocation(
			Long id,
			int latitude, 
			int longitude
			) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
        vars.put("latitude", String.valueOf(latitude));
        vars.put("longitude", String.valueOf(longitude));
        return restTemplate.getForObject(URL+UserRestURL.ENTITY_ID+UserRestURL.UPDATE_LOCATION+"?latitude={latitude}&longitude={longitude}", Boolean.class, vars);

	}
}
