package com.skillstorm.united.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.united.models.Flight;

public class FlightDAO {
	
	private static final String url = "jdbc:mysql://localhost:3306/training";
	private static final String username = "root";
	private static final String password = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Flight> loadAllFlights() {
		List<Flight> flights = new LinkedList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "select flight_number, airline, from_airport, to_airport, departure_date from flight ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				flights.add(new Flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flights;
	}
	
	public List<Flight> loadAllFlights(String from, String to) {
		String sql = "select flight_number, airline, from_airport, to_airport, "
				+ "departure_date from flight where from_airport = ? and to_airport = ?";
		List<Flight> flights = new LinkedList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, from);
			stmt.setString(2, to);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				flights.add(new Flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flights;
	}

	public void hello() {
		try (Connection conn = DriverManager.getConnection(null, null, null);) {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Flight findById(int id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "select flight_number, airline, from_airport, to_airport, departure_date from flight"
					+ " where flight_number = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				return new Flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
