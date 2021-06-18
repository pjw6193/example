package com.skillstorm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.services.TraineeService;
import com.skillstorm.trainee.models.Trainee;

@WebServlet("/trainee")
public class TraineeServlet extends HttpServlet {

	// component
	private TraineeService service = new TraineeService();
	
	/**
	 * Load all the trainees from database - glue to the model - send to a JSP page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// invoke the right service to get the right data
		List<Trainee> model = service.findAll();
		// glue the model to the view
		req.setAttribute("trainee_list", model);
		// directing user to the right "view" - redirect/forward
		req.getRequestDispatcher("trainee-list.jsp").forward(req, resp);
	}
	
	
}







