package com.example.demo;

import java.util.Optional;

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
@RequestMapping(path = "/emp")
public class EmployeeController {
	@Autowired
	private EmployeeRepo employeeRepo;

	// GET: get all employee
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllTc() {
		// This returns a JSON or XML with the users
		return employeeRepo.findAll();
	}

	// POST: Add a new employee
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewTc(@RequestParam("ssn") Integer ssn, @RequestParam("salary") Float salary,
			@RequestParam("union_mem_id") Integer union_mem_id) {
		Employee emp = new Employee();
		emp.setSsn(ssn);
		emp.setSalary(salary);
		emp.setUnion_mem_id(union_mem_id);
		employeeRepo.save(emp);
		return "Added new employee successfully";
	}

	// GET: get employees by ssn
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Employee> getEmployeeContactById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		return employeeRepo.findById(ssn);
	}

	// delete employee
	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String deleteEmployeeById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		employeeRepo.deleteById(ssn);
		return "deletion done";
	}
}
