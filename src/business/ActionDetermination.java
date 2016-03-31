package business;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import service.myService.ServiceDetermination;
import service.myService.ServiceDeterminationImpl;
import service.voMessage.ViewObject;
import strus.Form.ActionForm;
import strus.action.Action;

public class ActionDetermination implements Action {

	public String execute(HttpServletRequest request, ActionForm form, Map<String, String> actionForward) {
		String url = "";
		ServiceDetermination service = new ServiceDeterminationImpl();
		Map<String, ViewObject> mapObj = service.getViewObject(request.getParameter("text"));
		Set<String> mySet = mapObj.keySet();
		for(Iterator<String> it = mySet.iterator(); it.hasNext();) {
			url = it.next();
			request.setAttribute("output", mapObj.get(url));
		}
		return url;
	
	}

}
