package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.form.LoginForm;
import mvc.form.SocialPension;
import mvc.form.SuperForm;

import Action.Action;
import Action.LoginAction;
import Action.SocialPensionAction;
import Util.InterpretBean;

public class ServletAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ServletAction() {
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
		
		Action action = null;

//		String value = request.getParameter("sign");
		SuperForm superForm = (SuperForm) InterpretBean
				.interpret(request);
		
		if (request.getParameter("sign").equals("mvc.form.LoginForm")) {
			action = new LoginAction();
		}
		
		if(request.getParameter("sign").equals("mvc.form.SocialPension")) {
			action = new SocialPensionAction();
		}
		
		String result = action.execute(superForm);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		
//	    System.out.println(SuperForm);
		
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


}
