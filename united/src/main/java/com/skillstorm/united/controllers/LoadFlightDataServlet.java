package com.skillstorm.united.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.united.models.Flight;
import com.skillstorm.united.service.FlightService;

@WebServlet("/flights") // routes
public class LoadFlightDataServlet extends HttpServlet {

	FlightService service = new FlightService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// session: fromAirport, toAirport, departDate, arrivalDate
		String step = req.getParameter("step");

		if (step.equals("depart")) {
			String from = (String) req.getSession().getAttribute("fromAirport");
			String to = (String) req.getSession().getAttribute("toAirport");
			List<Flight> flights = service.loadAllFlights(from, to);
			req.setAttribute("flightData", flights);
			req.getRequestDispatcher("departing-flight.jsp").forward(req, resp);
		} else if (step.equals("return")) {
			String to = (String) req.getSession().getAttribute("fromAirport");
			String from = (String) req.getSession().getAttribute("toAirport");
			List<Flight> flights = service.loadAllFlights(from, to);
			req.setAttribute("flightData", flights);
			req.getRequestDispatcher("returning-flight.jsp").forward(req, resp);
		} else {
			throw new ServletException("Stop hackinz me");
		}
	}
}
