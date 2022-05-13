package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Controller // This means that this class is a Controller
@RequestMapping(path = "/empC")
public class EmployeeContactController {
	@Autowired
	private EmployeeContactRepo employeeContactRepo;

	// GET: get all contacts
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Phone_Number> getAllContacts() {
		// This returns a JSON or XML with the users
		return employeeContactRepo.findAll();
	}

	// POST: Add a new contact
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewContact(@RequestParam("ssn") Integer ssn,
			@RequestParam("phone_no") Integer phone_no) {
		Phone_Number tc = new Phone_Number();
		tc.setSsn(ssn);
		tc.setPh_no(phone_no);
		if (employeeContactRepo.save(tc) == null) {
			return "wrong input";
		}
		return "Added new contact successfully";
	}

	// GET: get contact by ssn
	@GetMapping(path = "/getByID")
	public @ResponseBody List<Integer> getEmployeeContactById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		// return employeeContactRepo.findById(ssn);
		return employeeContactRepo.allPhNoOfEmployee(ssn);
	}

	// delete contact
	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String deleteContactById(@RequestParam Integer ssn, @RequestParam Integer ph_no) {
		// This returns a JSON or XML with the users
		Phone_NumberID ph = new Phone_NumberID(ssn, ph_no);
		employeeContactRepo.deleteById(ph);
		return "deletion done";
	}
}
