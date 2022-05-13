package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Tested_By")
@IdClass(Tested_ByID.class)
public class Tested_By {
	@Id
	private Integer ssn;
	@Id
	private Integer test_id;

	public Tested_By() {

	}

	public Tested_By(Integer ssn, Integer test_id) {
		super();
		this.ssn = ssn;
		this.test_id = test_id;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
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
		Tested_By other = (Tested_By) obj;
		return Objects.equals(ssn, other.ssn) && Objects.equals(test_id, other.test_id);
	}

}
