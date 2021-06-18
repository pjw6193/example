package com.skillstorm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java EE (Enterprise Edition)
 * J2EE (Java 1.8) 
 * EJB, JPA 
 * 
 * HttpServlet class
 * Cookie/jsessionid
 * request.getParameter
 * input name=param_name
 * forward/redirect
 * request / session attributes
 * web.xml (deployment descriptor) tells tomcat about your project
 * WAR web application archive
 * form, method action
 * HTTP
 * scriptlet
 * 
 * server-side rendering 
 * client-side rendering (render the HTML page)
 * 
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// single-user app
		if(request.getParameter("user_username").equals("danp")) {
			// login success, save user info in the session, among many things
			request.getSession()
				.setAttribute("user_principal", request.getParameter("user_username"));
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			// login failed, store an error message, send back to login page
			request.setAttribute("login_error", "Login Failed. Try again.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}







