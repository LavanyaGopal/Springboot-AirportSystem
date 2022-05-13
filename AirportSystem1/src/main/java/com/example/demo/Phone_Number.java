package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Phone_Number")
@IdClass(Phone_NumberID.class)
//	implements Serializable
public class Phone_Number {
	@Id
	private Integer ssn;
	@Id
	private Integer ph_no;

	public Phone_Number() {
	}

	public Phone_Number(Integer ssn, Integer ph_no) {
		super();
		this.ssn = ssn;
		this.ph_no = ph_no;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Integer getPh_no() {
		return ph_no;
	}

	public void setPh_no(Integer ph_no) {
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
		Phone_Number other = (Phone_Number) obj;
		return Objects.equals(ph_no, other.ph_no) && Objects.equals(ssn, other.ssn);
	}

}
