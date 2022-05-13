package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

public class Tested_ByID implements Serializable {

	private Integer ssn;

	private Integer test_id;

	public Tested_ByID() {
		super();
	}

	public Tested_ByID(Integer ssn, Integer test_id) {
		super();
		this.ssn = ssn;
		this.test_id = test_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ssn, test_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tested_ByID other = (Tested_ByID) obj;
		return Objects.equals(ssn, other.ssn) && Objects.equals(test_id, other.test_id);
	}

}
