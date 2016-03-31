package service.myService;

import java.util.Map;

import service.voMessage.ViewObject;

public interface ServiceDetermination {
	
	public Map<String, ViewObject> getViewObject(String userName);

}
