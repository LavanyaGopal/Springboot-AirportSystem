package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

public class Expert_InID implements Serializable {

	private Integer ssn;
	private Integer model_id;

	public Expert_InID() {

	}

	public Expert_InID(Integer ssn, Integer model_id) {
		super();
		this.ssn = ssn;
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
		Expert_InID other = (Expert_InID) obj;
		return Objects.equals(model_id, other.model_id) && Objects.equals(ssn, other.ssn);
	}

}
