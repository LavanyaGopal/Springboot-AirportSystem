package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Expert_In")
@IdClass(Expert_InID.class)
public class Expert_In {
	@Id
	private Integer ssn;
	@Id
	private Integer model_id;

	public Expert_In() {

	}

	public Expert_In(Integer ssn, Integer model_id) {
		this.ssn = ssn;
		this.model_id = model_id;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model_id, ssn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expert_In other = (Expert_In) obj;
		return Objects.equals(model_id, other.model_id) && Objects.equals(ssn, other.ssn);
	}

}
