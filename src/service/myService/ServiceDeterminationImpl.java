package service.myService;

import java.util.HashMap;
import java.util.Map;

import service.voMessage.ViewObject;

public class ServiceDeterminationImpl implements ServiceDetermination {

	public Map<String, ViewObject> getViewObject(String userName) {
		Map<String, ViewObject> voMap = new HashMap<String, ViewObject>();
		ViewObject vo = new ViewObject();
		if (userName.equals("Derek")) {
			vo.setAddress("message");
			vo.setMessage1("Welcome, Derek");
			
			voMap.put("/view/success.jsp", vo);
		}else{
			vo.setAddress("message");
			vo.setMessage1("this user is invalid");
			voMap.put("/view/Failure.jsp", vo);
		}
		
		return voMap;
		
	}


}
