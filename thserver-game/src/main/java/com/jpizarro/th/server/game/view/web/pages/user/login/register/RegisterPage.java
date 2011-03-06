package com.jpizarro.th.server.game.view.web.pages.user.login.register;

import java.io.Serializable;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.game.view.web.application.WicketApplication;
import com.jpizarro.th.server.game.view.web.pages.BasePage;
import com.jpizarro.th.server.game.view.web.session.WicketSession;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;

@MountPath(path = "register")
public class RegisterPage extends BasePage {

	public RegisterPage() {
		super();
		// TODO Auto-generated constructor stub+
		add(new RegisterForm("registerform", new Model(new SimpleUser())));
	}

	public RegisterPage(PageParameters parameters) {
		this();
	}

	@Override
	protected String getTitle() {
		return getLocalizer().getString("registerPage.title", RegisterPage.this);
	}
	
	public final class RegisterForm extends Form {

		public RegisterForm(String id, IModel model) {
			super(id, new CompoundPropertyModel(model));
			// TODO Auto-generated constructor stub
			add(new TextField("username").setRequired(true));
            add(new PasswordTextField("password").setResetPassword(true));
            add(new PasswordTextField("retypePassword").setResetPassword(true));
            add(new TextField("email").setRequired(true));
		}

		@Override
		protected void onSubmit() {
			SimpleUser user = ((SimpleUser) getModel().getObject());
            String username = user.getUsername();
            String password = user.getPassword();
            String retypePassword = user.getRetypePassword();
            if (!password.equals(retypePassword)) {
            	error(getLocalizer().getString("registerPage.errors.passwordAndRetypedPasswordDontMatch", RegisterPage.this));
            }
            String email = user.getEmail();
            
            if (!hasError()){
	            UserRegisterTO userInfoTO = new UserRegisterTO(
	            		username,
	            		password,
	            		email
	            		);
//	            try {
//					WicketApplication.get().getUserService().register(userInfoTO);
					
					if (WicketSession.get().signIn(username, password)){
						setResponsePage(getApplication().getHomePage());
					}else
						error(getLocalizer().getString("register.errors.errorRegistering", RegisterPage.this));
//				} catch (DuplicateInstanceException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
            }
            
            setRedirect(true);
		}
		
	}
	
	public static class SimpleUser implements Serializable {
		
		private String username;
    	private String password;
    	private String retypePassword;
    	private String email;
    	private boolean showPersonalInfo;
    	private String phone;
    	private String name;
    	private String surname;
    	private String country;
    	
		public void setUsername(String username) {
			this.username = username;
		}

		public String getUsername() {
			return username;
		}
    	
    	public String getPassword() {
    		return this.password;
    	}
    	
    	public void setPassword(String password) {
    		this.password = password;
    	}

		public String getRetypePassword() {
			return this.retypePassword;
		}

		public void setRetypePassword(String retypePassword) {
			this.retypePassword = retypePassword;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isShowPersonalInfo() {
			return this.showPersonalInfo;
		}

		public void setShowPersonalInfo(boolean showPersonalInfo) {
			this.showPersonalInfo = showPersonalInfo;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return this.surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getCountry() {
			return this.country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		
	}

}
