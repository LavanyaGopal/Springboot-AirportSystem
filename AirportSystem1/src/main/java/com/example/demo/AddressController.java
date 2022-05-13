package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Controller // This means that this class is a Controller
@RequestMapping(path = "/empA")
public class AddressController {
	@Autowired
	private AddressRepo addressRepo;

	// GET: get all address
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Address> getAllTc() {
		// This returns a JSON or XML with the users
		return addressRepo.findAll();
	}

	// POST: Add a new address
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewTc(@RequestParam("ssn") Integer ssn,
			@RequestParam("address_line1") String address_line1, @RequestParam("address_line2") String address_line2,
			@RequestParam("city") String city, @RequestParam("state") String state,
			@RequestParam("pincode") String pincode) {
		Address address = new Address();
		address.setSsn(ssn);
		address.setAddress_line1(address_line1);
		address.setAddress_line2(address_line2);
		address.setCity(city);
		address.setState(state);
		address.setPincode(pincode);
		addressRepo.save(address);
		return "Added new address successfully";
	}

	// GET: get address by ssn
	@GetMapping(path = "/getByID")
	public @ResponseBody String getEmployeeAddressById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		// List<String> allAddress = new List<String>();
		String add = "";
		List<Address> addresses = addressRepo.getAddBasedOnSsn(ssn);
		addresses.toString();
		for (Address address : addresses) {
			add += address.toString();
		}
		return add;
		// return addressRepo.findById(ssn);
	}

}
