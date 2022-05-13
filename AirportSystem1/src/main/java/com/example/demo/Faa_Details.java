package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faa_Details {
	@Id
	Integer test_id;
	Integer aircraft_id;
	Float score;
	Date date;
	Integer no_of_hours;

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public Integer getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(Integer aircraft_id) {
		this.aircraft_id = aircraft_id;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNo_of_hours() {
		return no_of_hours;
	}

	public void setNo_of_hours(Integer no_of_hours) {
		this.no_of_hours = no_of_hours;
	}

}
