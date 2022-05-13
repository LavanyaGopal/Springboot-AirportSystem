package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class TrafficController {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ssn;

	private Date med_date;

	private String status;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Date getMed_date() {
		return med_date;
	}

	public void setMed_date(Date med_date) {
		this.med_date = med_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
