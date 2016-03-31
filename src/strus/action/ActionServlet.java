package strus.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ActionDetermination;
import service.voMessage.ViewObject;
import strus.Form.ActionForm;
import strus.Form.InterpretBean;
import strus.Form.xmlBean;

public class ActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7597280557618665906L;

	/**
	 * Constructor of the object.
	 */
	public ActionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = this.getPath(request.getServletPath());
		Map<String, xmlBean> xmlObj = (Map<String, xmlBean>) this.getServletContext().getAttribute("strus-config");
		xmlBean xmlBeanObj = xmlObj.get(path);
		ActionForm actionForm = InterpretBean.getForm(xmlBeanObj.getFormClass(), request);
		
		try {
			Class actionClass = Class.forName(xmlBeanObj.getActionClass());
			Action action = (Action) actionClass.newInstance();
			String resultPath = action.execute(request, actionForm, xmlBeanObj.getActionForward());
			if (resultPath != null && !"".equals(resultPath)) {
				request.getRequestDispatcher(resultPath).forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	private String getPath(String servletPath) {
		return servletPath.split("\\.")[0];
		
	}

}
