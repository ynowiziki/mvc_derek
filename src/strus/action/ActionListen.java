package strus.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import strus.Form.AnotationBean;
import strus.Form.AnotationInterpret;


public class ActionListen implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.print("The applicaiton is logging off");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Starting to load the configuraiton file");
		ServletContext context = arg0.getServletContext();
		String annotationPath = context.getInitParameter("annotationPath");
		String realPath = context.getRealPath("\\");
		Map<String, AnotationBean> configBeans = null;
		try {
			configBeans = AnotationInterpret.strutsAnotationInterpret();
		} catch (Exception e) {
			e.printStackTrace();
		}
		context.setAttribute(annotationPath, configBeans);
		

	}

}
