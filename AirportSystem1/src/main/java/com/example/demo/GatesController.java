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
@RequestMapping(path = "/gates")
public class GatesController {
	@Autowired
	private GatesRepo gatesrepo1;

	// GET: get all airlines
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Gates> getAllGates() {
		// This returns a JSON or XML with the users
		return gatesrepo1.findAll();
	}

	// POST: Add a new Airlines
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewGate(@RequestParam("airline_id") Integer airline_id,
			@RequestParam("gate_id") Integer gate_id) {
		Gates gate = new Gates();
		gate.setAirline_id(airline_id);
		gate.setGate_id(gate_id);
		gatesrepo1.save(gate);
		return "Added new gate successfully";
	}

	// GET: get Airlines by airline Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Gates> getGateById(@RequestParam Integer gate_id) {
		// This returns a JSON or XML with the users
		return gatesrepo1.findById(gate_id);
	}

	// DELETE : delete an airline

	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String deleteGateById(@RequestParam Integer gate_id) {
		// This returns a JSON or XML with the users
		gatesrepo1.deleteById(gate_id);
		return "deletion done";
	}
}
