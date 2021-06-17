package com.skillstorm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTTP methods 
 * 
 * Idempotence - subsequent calls to the same method have ZERO adverse affect
 * 
 * GET		fetch a page, data, etc. GET the data for trainee #1 (idempotent) 
 * 
 * POST		create/save something (record in db, anything) state has permanently changed
 * 			example: create a new Trainee (Erika) -> 1 - Erika
 * 					 create a new Trainee (Erika) -> 2 - Erika
 *   				 create a new Trainee (Erika) -> 3 - Erika
 * 
 * PUT		update something (record in db, data, etc.) (idempotent)
 * 			example: change name from Sean Carter to Sean Bradley
 * 					 change name from Sean Bradley to Sean Bradley
 * 					 change name from Sean Bradley to Sean Bradley
 * 
 * DELETE	delete something on the server (idempotent)
 * 			example: delete trainee #103 -> delete statement (1 row affected)
 *  				 delete trainee #103 -> delete statement (0 rows affected)
 * 
 * Responses: (status codes)
 * 
 * 1xx : Informational
 * 2xx : Good 
 * 			200 - OK
 * 			201 - Created (record made, usually used with POST)
 * 			204 - No Content (successful, but server gave no response body) DELETE
 * 3xx : Redirection
 * 			301 - Permanent redirect
 * 			302 - Temporary redirect
 * 4xx : Client Error 
 * 			400 - Bad Request (malformed json, malformed request, syntax error)
 * 			401 - Unauthorized (not logged in - not authenticated)
 * 			403 - Forbidden (you may logged in, but not allowed to call this operation)
 * 			404 - Page Not Found
 * 			415 - Unsupported Media Type (server expects JSON, you pass it XML) 
 * 5xx : Server Error
 * 			500 - Internal Server Error (unhandled exception on the server-side)
 * 			503 - Gateway Timeout (networking gateway issue)
 * 
 * 
 */
@WebServlet(urlPatterns = "/register") // <form action="register">
public class RegisterServlet extends HttpServlet {

	// <form method="post" action="register">
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form data
		String username = request.getParameter("username");
		String password = request.getParameter("passw");
		
		System.out.println(username + " " + password);
		
		// stores a value (or a whole object) in request
		request.setAttribute("authenticated_user", username); 
		request.getSession().setAttribute("user_password", password);
		response.addCookie(new Cookie("pepper", "salt"));
		
		//response.getWriter().print("{ username: " + username + " } ");
		
		// forward OR redirect: sending to a different page
		// forward: client is unaware that a forward had happened (all server-side)
		
		// forward request: forwarding the attributes
		request.getRequestDispatcher("home-page.jsp").forward(request, response);
		//response.sendRedirect("home-page.html");
		
		// redirect them to this page
		//response.sendRedirect("home-page.html"); // "return"
		// response.sendError(0); // return statements
		// response.setStatus(0);
	}
	
	// <form method="get" action="register">
	/**
	 * in a GET request, parameters are passed in the URL
	 * i.e. http://localhost:8080/j2ee/register?param=value&key=value2
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET");
	}
	
}











