package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

public class Phone_NumberID implements Serializable {
	private Integer ssn;
	private Integer ph_no;

	public Phone_NumberID() {
		super();
	}

	public Phone_NumberID(Integer ssn, Integer ph_no) {
		super();
		this.ssn = ssn;
		this.ph_no = ph_no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ph_no, ssn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone_NumberID other = (Phone_NumberID) obj;
		return Objects.equals(ph_no, other.ph_no) && Objects.equals(ssn, other.ssn);
	}

}
