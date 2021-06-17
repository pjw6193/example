package com.skillstorm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 */
@WebServlet(urlPatterns = "/register") // <form action="register">
public class RegisterServlet extends HttpServlet {

	// <form method="post" action="register">
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form data
		String username = request.getParameter("username");
		String password = request.getParameter("passw");
		
		System.out.println(username + " " + password);
		// dao.save or whatever I want with that data
	}
	
	// <form method="get" action="register">
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET");
	}
	
}











