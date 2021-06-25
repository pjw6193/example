package com.skillstorm.united.service;

import java.util.List;

import com.skillstorm.united.data.FlightDAO;
import com.skillstorm.united.models.Customer;
import com.skillstorm.united.models.Flight;

public class FlightService {

	FlightDAO dao = new FlightDAO();
	
	public void hello() {
		dao.hello();
	}
	
	public List<Flight> loadAllFlights() {
		return dao.loadAllFlights();
	}
	
	public List<Flight> loadAllFlights(String from, String to) {
		return dao.loadAllFlights(from, to);
	}
	
	public Flight findById(int id) {
		return dao.findById(id);
	}

	public Customer getCustomerByEmail(String email) {
		// if customer email exists, load existing customer record
		// else create a new customer record
		return new Customer(101, "dan@email.com", "Pickles", "Dan");
	}
	
	
}
