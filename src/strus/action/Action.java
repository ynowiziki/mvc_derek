package strus.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import strus.Form.ActionForm;

public interface Action {
	
	public String execute(HttpServletRequest request, ActionForm form, Map<String, String> actionForward) ;

}
