package com.skillstorm.united.models;

import java.util.Date;

public class Reservation {

	private int reservationNumber;
	private Customer customer;
	private Flight departing;
	private Flight returning;
	private Date reservationDate;
	
	public Reservation() {
		super();
	}
	
	
	public int getReservationNumber() {
		return reservationNumber;
	}


	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}


	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Flight getDeparting() {
		return departing;
	}
	public void setDeparting(Flight departing) {
		this.departing = departing;
	}
	public Flight getReturning() {
		return returning;
	}
	public void setReturning(Flight returning) {
		this.returning = returning;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}


	@Override
	public String toString() {
		return "Reservation [reservationNumber=" + reservationNumber + ", customer=" + customer + ", departing="
				+ departing + ", returning=" + returning + ", reservationDate=" + reservationDate + "]";
	}
	
	
	
}
