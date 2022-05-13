package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gates {

	@Id
	Integer gate_id;
	Integer airline_id;

	public Integer getGate_id() {
		return gate_id;
	}

	public void setGate_id(Integer gate_id) {
		this.gate_id = gate_id;
	}

	public Integer getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(Integer airline_id) {
		this.airline_id = airline_id;
	}

}
