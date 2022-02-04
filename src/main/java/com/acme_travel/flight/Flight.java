package com.acme_travel.flight;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="flights_tamarad123")

public class Flight implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6492688440261480186L;

	@Id
	@Column(name="flight_code")
	public String flightCode;
	
	@Column(name="airline_name")
	public String airlineName;
	
	@Column(name="departure_airport")
	public String departureAirport;
	
	@Column(name="destination_airport")
	public String destinationAirport;
	
	//Changed to Timestamp instead of LocalDateTime, as per hibernate down graded version will have to create Converter
	@Column(name="departure_date")
	public Timestamp departureDate;
	
	@Column(name="aircraft_type")
	public String aircratfType;
	
	@Column(name="seat_availability")
	public Double seatAvailability;
	
	@Column(name="price")
	public Double price;

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Timestamp getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}

	public String getAircratfType() {
		return aircratfType;
	}

	public void setAircratfType(String aircratfType) {
		this.aircratfType = aircratfType;
	}

	public Double getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(Double seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
