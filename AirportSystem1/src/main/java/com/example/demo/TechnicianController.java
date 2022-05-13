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
@RequestMapping(path = "/tech")
public class TechnicianController {
	@Autowired
	private TechnicianRepo tcrepo1;

	// GET: get all airlines
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Technician> getAllTc() {
		// This returns a JSON or XML with the users
		return tcrepo1.findAll();
	}

	// POST: Add a new Airlines
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewTc(@RequestParam("ssn") Integer ssn, @RequestParam("AreaOfX") String AreaOfX) {
		Technician tc = new Technician();
		tc.setSsn(ssn);
		tc.setArea_of_expertise(AreaOfX);
		tcrepo1.save(tc);
		return "Added new Technician successfully";
	}

	// GET: get Airlines by airline Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Technician> getTechnicianById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		return tcrepo1.findById(ssn);
	}

	// DELETE : delete an airline

	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String TechnicianById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		tcrepo1.deleteById(ssn);
		return "deletion done";

	}

	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody String updateTechnician(@RequestParam("AreaOfX") String AreaOfX,
			@RequestParam("ssn") Integer ssn) {

		if (tcrepo1.findById(ssn) != null) {
			Technician tc1 = tcrepo1.findById(ssn).get();
			if (tc1.getArea_of_expertise() != AreaOfX) {
				tc1.setArea_of_expertise(AreaOfX);
			}

			tcrepo1.save(tc1);
			return "Updated AreaOfX successfully";
		}
		return "Tech doesn't exist";

	}
}
