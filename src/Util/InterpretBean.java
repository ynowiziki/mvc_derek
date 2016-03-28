package Util;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import mvc.form.SuperForm;

public class InterpretBean {
	
	public InterpretBean() {
		
	}
	
	public static SuperForm interpret(HttpServletRequest request) {
		SuperForm obj = null;
		try{
			Class cls = Class.forName(request.getParameter("sign"));
			obj = (SuperForm) cls.newInstance();
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
