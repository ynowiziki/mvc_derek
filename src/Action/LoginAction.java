package Action;

import mvc.form.LoginForm;
import mvc.form.SuperForm;

public class LoginAction implements Action {

	public String execute(SuperForm superForm) {
		LoginForm loginForm = (LoginForm)superForm;
		
		return loginForm.toString();
	}

}
