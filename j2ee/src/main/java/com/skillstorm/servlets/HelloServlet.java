package com.skillstorm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet: a Java class that handles HTTP requests
 * 
 * We "talk" to this servlet using the URL in @WebServlet:
 * 		http://localhost:8080/j2ee/hello
 *
 * GET http://localhost:8080/j2ee/hello -> call doGet method
 * 
 */
@WebServlet(urlPatterns = "/hello")  
public class HelloServlet extends HttpServlet {

	/**
	 * if we send HTTP GET request: call this method
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Hello Servlet");
		
	}
	
}







