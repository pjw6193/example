package com.skillstorm.united.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.skillstorm.united.service.ReservationService;

@WebServlet("/hello") // routes
public class ReservationServlet extends HttpServlet {

	ReservationService service = new ReservationService();
	
}
