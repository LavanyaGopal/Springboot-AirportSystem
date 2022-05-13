package com.example.demo;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
	Integer emp_id;
	String first_name;
	String middle_name;
	String last_name;
	String role;
	Date DOB;
	String password;

	public User() {
		super();
	}

	public User(Integer emp_id, String first_name, String middle_name, String last_name, String role, Date dOB,
			String password) {
		super();
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.role = role;
		DOB = dOB;
		this.password = password;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [emp_id=" + emp_id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", role=" + role + ", DOB=" + DOB + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(DOB, emp_id, first_name, last_name, middle_name, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(DOB, other.DOB) && Objects.equals(emp_id, other.emp_id)
				&& Objects.equals(first_name, other.first_name) && Objects.equals(last_name, other.last_name)
				&& Objects.equals(middle_name, other.middle_name) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role);
	}

}