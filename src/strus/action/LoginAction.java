package strus.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import annotation.AnnotationConfig;
import annotation.AnnotationAction;

import strus.Form.ActionForm;
import strus.Form.LoginForm;


@AnnotationConfig 

(  path="/sss",
   beanName="", 
   actionClass="action.LoginAction",
   formClass="Form.LoginForm",
   mapUrl = {
		@AnnotationAction(name="fail",action="/view/Failed.jsp"),
		@AnnotationAction(name="success",action="/view/success.jsp")}
)

public class LoginAction implements Action{

public String execute(HttpServletRequest request, ActionForm form,
	Map<String, String> actionForward) {

	String url = "fail";
	LoginForm sForm = (LoginForm)form;
	if(sForm.getUserName().equals("Derek")){
		url = "success";
	}
	
	return actionForward.get(url);
}
}