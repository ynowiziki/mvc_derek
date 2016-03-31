package strus.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import strus.Form.xmlBean;
import strus.Form.xmlInterpret;

public class ActionListen implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.print("The applicaiton is logging off");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Starting to load the configuraiton file");
		ServletContext context = arg0.getServletContext();
		String configFilePath = context.getInitParameter("strus-config");
		String realPath = context.getRealPath("\\");
		Map<String, xmlBean> configBeans = null;
		try {
			configBeans = xmlInterpret.interpret(realPath + configFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		context.setAttribute("strusConfig", configBeans);
		

	}

}
