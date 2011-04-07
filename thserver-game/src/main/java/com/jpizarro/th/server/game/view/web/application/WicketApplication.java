package com.jpizarro.th.server.game.view.web.application;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequestCycleProcessor;
import org.apache.wicket.protocol.http.request.CryptedUrlWebRequestCodingStrategy;
import org.apache.wicket.protocol.http.request.WebRequestCodingStrategy;
import org.apache.wicket.request.IRequestCodingStrategy;
import org.apache.wicket.request.IRequestCycleProcessor;
import org.apache.wicket.request.target.coding.MixedParamUrlCodingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.game.view.web.pages.home.anonymous.AnonymousHomePage;
import com.jpizarro.th.server.game.view.web.pages.home.user.UserHomePage;
import com.jpizarro.th.server.game.view.web.session.WicketSession;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.place.model.service.PlaceService;
import com.jpizarro.th.server.team.model.service.TeamService;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
@Component
public class WicketApplication extends AuthenticatedWebApplication
{ 
	@Autowired
	private CustomAuthenticationManager customAuthenticationManager;
	
	@Autowired
	private UserService userService;

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private GameService gameService;
		
    public CustomAuthenticationManager getCustomAuthenticationManager() {
		return customAuthenticationManager;
	}

	/**
     * Constructor
     */
	public WicketApplication()
	{
		super();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
		
		new AnnotatedMountScanner().scanPackage("com.jpizarro.th.server").mount(this);

//		getApplicationSettings().setAccessDeniedPage(LoginPage.class);
		/*
         * Remove wicket tags from result HTML
         */
        getMarkupSettings().setStripWicketTags(true);
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<? extends WebPage> getHomePage()
	{
		WicketSession session = WicketSession.get();
		if (session.isSignedIn() && !session.isSessionInvalidated()) {
			for (String role : session.getRoles()) {
//				if (role.equals("ROLE_ADMIN"))
//					return HomePage.class;
				if (role.equals("ROLE_USER"))
					return UserHomePage.class;
			}
		}
		return AnonymousHomePage.class;
//		return null;
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return new WicketSession(request);
	}
	
//	@Override
//	protected IRequestCycleProcessor newRequestCycleProcessor() {
//
//		return new WebRequestCycleProcessor() {
//			@Override
//			protected IRequestCodingStrategy newRequestCodingStrategy() {
//				return new CryptedUrlWebRequestCodingStrategy(new WebRequestCodingStrategy());
//			}
//		};
//	}
	
	public static WicketApplication get() {
        return (WicketApplication) Application.get();
    }

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return AnonymousHomePage.class;
	}

	@Override
	protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
		return WicketSession.class;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public GameService getGameService() {
		return gameService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}

	public PlaceService getPlaceService() {
		return placeService;
	}
	

}
