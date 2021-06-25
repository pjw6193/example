package com.skillstorm.united.models;

import java.util.Date;

// pojos/model
public class Flight {

	private int flightNumber;
	private String airline;
	private String fromAirport;
	private String toAirport;
	private Date departure;
	
	public Flight() {
		super();
	}
	public Flight(int flightNumber, String airline, String fromAirport, String toAirport, Date departure) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
		this.departure = departure;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}
	public String getToAirport() {
		return toAirport;
	}
	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", airline=" + airline + ", fromAirport=" + fromAirport
				+ ", toAirport=" + toAirport + ", departure=" + departure + "]";
	}
	
	
	
}
// getter setters