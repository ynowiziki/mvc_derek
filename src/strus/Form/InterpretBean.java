package strus.Form;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class InterpretBean {
	
	public InterpretBean () {
		
	}
	
	public static ActionForm  getForm(String formPath, HttpServletRequest request) {
		
		ActionForm obj = null;
		try{
			Class cls = Class.forName(request.getParameter(formPath));
			obj = (ActionForm) cls.newInstance();
			Field[] f_ar = cls.getDeclaredFields();
			
			for(Field f: f_ar) {
				f.setAccessible(true);
				f.set(obj, request.getParameter(f.getName()));
				f.setAccessible(false);
			}
			
		}catch(Exception e){
			
		}
		return obj;
			
		
		
	}

}
