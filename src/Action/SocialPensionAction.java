package Action;

import mvc.form.SocialPension;
import mvc.form.SuperForm;

public class SocialPensionAction implements Action {

	public String execute(SuperForm superForm) {
		SocialPension socialPension = (SocialPension)superForm;
		return socialPension.toString();
	}

}
