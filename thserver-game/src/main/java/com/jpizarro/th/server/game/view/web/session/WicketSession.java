package com.jpizarro.th.server.game.view.web.session;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.authorization.strategies.role.Roles;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.server.game.view.web.application.WicketApplication;

public class WicketSession extends AuthenticatedWebSession {

	private LoginResultTO loginResultTO;

	public WicketSession(Request request) {
		super(request);
		// TODO Auto-generated constructor stub
	}


	
	public static WicketSession get() {
        return (WicketSession) Session.get();
    }

	@Override
	public boolean authenticate(String username, String password) {
		boolean authenticated = false;
		try {
			Authentication authentication = WicketApplication.get().getCustomAuthenticationManager().authenticate(
            		new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
            authenticated = authentication.isAuthenticated();
            this.loginResultTO = (LoginResultTO) authentication.getPrincipal();
        } catch (AuthenticationException e) {
        	System.out.println(e);
            authenticated = false;
        }
        return authenticated;
	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
		if (this.isSignedIn()) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			for (GrantedAuthority authority : authentication.getAuthorities()) {
	            roles.add(authority.getAuthority());
	        }
		}
		return roles;
	}

	@Override
	public void signOut() {
		SecurityContextHolder.getContext().setAuthentication(null);
        invalidate();
		super.signOut();
	}

	public LoginResultTO getLoginResultTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
