package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Technician {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ssn;

	private String area_of_expertise;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getArea_of_expertise() {
		return area_of_expertise;
	}

	public void setArea_of_expertise(String area_of_expertise) {
		this.area_of_expertise = area_of_expertise;
	}

}
