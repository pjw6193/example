package com.skillstorm.united.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.united.models.Reservation;
import com.skillstorm.united.service.FlightService;

@WebServlet("/returning-flight")
public class ReturningFlightServlet extends HttpServlet {

	FlightService service = new FlightService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectedReturningFlightNumber = req.getParameter("selected-returning-flight-number");
		// input validation
		System.out.println(selectedReturningFlightNumber);
		// loading their progress
		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		
		reservation.setReturning(service.findById(Integer.parseInt(selectedReturningFlightNumber)));
		
		req.getSession().setAttribute("reservation", reservation);
		System.out.println(reservation);
		
		// forward them to a page to fill out customer information
		
		resp.sendRedirect("customer-details.jsp");
	}
	
}
