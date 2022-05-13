package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

public class AddressID implements Serializable {

	private Integer ssn;

	private String address_line1;

	private String address_line2;

	private String city;

	private String state;

	private String pincode;

	public AddressID() {

	}

	public AddressID(Integer ssn, String address_line1, String address_line2, String city, String state,
			String pincode) {
		super();
		this.ssn = ssn;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address_line1, address_line2, city, pincode, ssn, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressID other = (AddressID) obj;
		return Objects.equals(address_line1, other.address_line1) && Objects.equals(address_line2, other.address_line2)
				&& Objects.equals(city, other.city) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(ssn, other.ssn) && Objects.equals(state, other.state);
	}

}
