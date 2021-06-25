package com.skillstorm.united.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.united.models.Reservation;

@WebServlet("/initializeReservation")
public class ReservationInitializationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reservation reservation = new Reservation();
		reservation.setReservationDate(new Date());
		req.getSession().setAttribute("reservation", reservation);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		req.getSession().setAttribute("fromAirport", req.getParameter("fromAirport"));
		try {
			req.getSession().setAttribute("departDate", fmt.parse(req.getParameter("departDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getSession().setAttribute("toAirport", req.getParameter("toAirport"));
		try {
			req.getSession().setAttribute("arrivalDate", fmt.parse(req.getParameter("departDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("flights?step=depart");
	}

}
