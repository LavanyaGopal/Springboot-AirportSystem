package com.example.demo;

import java.sql.Date;
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
@RequestMapping(path = "/tc")
public class TcController {
	@Autowired
	private TrafficControllerRepo tcrepo1;

	// GET: get all airlines
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<TrafficController> getAllTc() {
		// This returns a JSON or XML with the users
		return tcrepo1.findAll();
	}

	// POST: Add a new Airlines
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewTc(@RequestParam("ssn") Integer ssn, @RequestParam("status") String status,
			@RequestParam("med_date") Date med_date) {
		TrafficController tc = new TrafficController();
		tc.setSsn(ssn);
		tc.setMed_date(med_date);
		tc.setStatus(status);
		tcrepo1.save(tc);
		return "Added new TC successfully";
	}

	// GET: get Airlines by airline Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<TrafficController> getTrafficControllerById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		return tcrepo1.findById(ssn);
	}

	// DELETE : delete an airline

	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String TrafficControllerById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		tcrepo1.deleteById(ssn);
		return "deletion done";

	}

	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody String updateTrafficController(@RequestParam("med_date") Date med_date,
			@RequestParam("ssn") Integer ssn) {

		if (tcrepo1.findById(ssn) != null) {
			TrafficController tc1 = tcrepo1.findById(ssn).get();
			if (tc1.getMed_date() != med_date) {
				tc1.setMed_date(med_date);
			}

			tcrepo1.save(tc1);
			return "Updated med_date successfully";
		}
		return "TC doesn't exist";

	}
}
