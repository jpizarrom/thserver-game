package com.jpizarro.th.server.game.view.web.pages.user.login;

import java.io.Serializable;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
//import org.wicketstuff.annotation.mount.MountPath;

import com.jpizarro.th.server.game.view.web.pages.BasePage;
import com.jpizarro.th.server.game.view.web.session.WicketSession;

//@MountPath(path = "login")
public class LoginPage extends BasePage {

	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
		add(new SignInForm("loginform", new Model(new SimpleUser())));
		
		if (WicketSession.get().isSignedIn()){
			setResponsePage(getApplication().getHomePage());
		}
	}

	public LoginPage(PageParameters parameters) {
		this();
	}

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public final class SignInForm extends Form {

		public SignInForm(String id, IModel model) {
			super(id, new CompoundPropertyModel(model));
            add(new TextField("username").setRequired(true));
            add(new PasswordTextField("password").setResetPassword(true));
		}

		@Override
		protected void onSubmit() {
			// TODO Auto-generated method stub
			SimpleUser user = ((SimpleUser) getModel().getObject());
            String username = user.getUsername();
            String password = user.getPassword();
                        
            if(WicketSession.get().signIn(username, password)){
            	setResponsePage(getApplication().getHomePage());
            }else{
            	error(getLocalizer().getString("loginPage.errors.invalidCredentials", LoginPage.this));
            }
            
            setRedirect(true);
		}
		
	}
	
	public static class SimpleUser implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String username;
    	private String password;

    	public String getUsername() {
    		return this.username;
    	}
    	
    	public void setUsername(String username) {
    		this.username = username;
    	}
    	
    	public String getPassword() {
    		return this.password;
    	}
    	
    	public void setPassword(String password) {
    		this.password = password;
    	}
	}

}
