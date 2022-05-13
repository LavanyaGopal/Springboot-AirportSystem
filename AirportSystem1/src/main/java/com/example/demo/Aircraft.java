package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aircraft {
	@Id
	Integer aircraft_id;
	Integer model_id;
	String flight_status;
	Integer airline_id;

	public Integer getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(Integer aircraft_id) {
		this.aircraft_id = aircraft_id;
	}

	public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	public String getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(String flight_status) {
		this.flight_status = flight_status;
	}

	public Integer getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(Integer airline_id) {
		this.airline_id = airline_id;
	}

}