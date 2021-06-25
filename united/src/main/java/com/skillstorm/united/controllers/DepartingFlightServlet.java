package com.skillstorm.united.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.united.models.Reservation;
import com.skillstorm.united.service.FlightService;

@WebServlet("/departing-flight")
public class DepartingFlightServlet extends HttpServlet {

	FlightService service = new FlightService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectedDepartingFlightNumber = req.getParameter("selected-departing-flight-number");
		// input validation
		System.out.println(selectedDepartingFlightNumber);
		
		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation"); 
		reservation.setDeparting(service.findById(Integer.parseInt(selectedDepartingFlightNumber)));
		
		req.getSession().setAttribute("reservation", reservation);
		resp.sendRedirect("flights?step=return");
	}
	
}
