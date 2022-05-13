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

//import com.example.model.Airlines;
//import com.example.repo.AirlinesRepo;

@Service
@Controller // This means that this class is a Controller
@RequestMapping(path = "/airlines")
public class AirlinesController {

	@Autowired
	private AirlinesRepo airlinesRepo1;

	// GET: get all airlines
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Airlines> getAllAirlines() {
		// This returns a JSON or XML with the users
		return airlinesRepo1.findAll();
	}

	// POST: Add a new Airlines
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewAirline(@RequestParam("airline_id") Integer airline_id,
			@RequestParam("name") String name) {
		Airlines airline = new Airlines();
		airline.setAirline_id(airline_id);
		airline.setName(name);
		airlinesRepo1.save(airline);
		return "Added new airline successfully";
	}

	// GET: get Airlines by airline Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Airlines> getAirlineById(@RequestParam Integer aId) {
		// This returns a JSON or XML with the users
		return airlinesRepo1.findById(aId);
	}

	// DELETE : delete an airline

	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String deleteAirlineById(@RequestParam Integer aId) {
		// This returns a JSON or XML with the users
		airlinesRepo1.deleteById(aId);
		return "deletion done";
	}
}
