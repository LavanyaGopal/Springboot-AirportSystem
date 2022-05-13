package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// implements Serializable
public class Employee {

	@Id
	Integer ssn;
	Float salary;
	Integer union_mem_id;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Integer getUnion_mem_id() {
		return union_mem_id;
	}

	public void setUnion_mem_id(Integer union_mem_id) {
		this.union_mem_id = union_mem_id;
	}
}
