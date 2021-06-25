package com.skillstorm.united.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.united.models.Customer;
import com.skillstorm.united.models.Reservation;
import com.skillstorm.united.service.FlightService;

@WebServlet("/customerDetails")
public class CustomerDetailsServlet extends HttpServlet {

	private FlightService service = new FlightService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		Customer customer = service.getCustomerByEmail(email);
		reservation.setCustomer(customer);
		// save the reservation get back the confirm number
		reservation.setReservationNumber(199172); // pretend
		req.getSession().setAttribute("reservation", reservation); //update session variable
		resp.sendRedirect("confirmation.jsp");
	}

}
