package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Model {
	@Id
	Integer model_id;
	Integer weight;
	Integer capacity;

	public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

}
