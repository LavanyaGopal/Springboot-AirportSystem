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
@RequestMapping(path = "/aircraft")
public class AircraftController {

	@Autowired
	private AircraftRepo aircraftRepo;

	// GET: get all aircrafts
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Aircraft> getAllAircrafts() {
		// This returns a JSON or XML with the users
		return aircraftRepo.findAll();
	}

	// GET: get model by aircraft Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Aircraft> getAircraftById(@RequestParam Integer aId) {
		// This returns a JSON or XML with the users
		return aircraftRepo.findById(aId);
	}

	// POST: Add a new
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewAircraft(@RequestParam("aircraft_Id") Integer aircraft_Id,
			@RequestParam("mId") Integer mId, @RequestParam("flight_status") String flight_status,
			@RequestParam("airline_id") Integer airline_id) {
		Aircraft aircraft = new Aircraft();
		aircraft.setAircraft_id(aircraft_Id);
		aircraft.setModel_id(mId);
		aircraft.setFlight_status(flight_status);
		aircraft.setAirline_id(airline_id);
		aircraftRepo.save(aircraft);
		return "Added new aircraft successfully";
	}

	// update an existing model

	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody String updateAircraft(@RequestParam("aircraft_Id") Integer aircraft_Id,
			@RequestParam("mId") Integer mId, @RequestParam("flight_status") String flight_status,
			@RequestParam("airline_id") Integer airline_id) {
		Aircraft aircraft = new Aircraft();
		aircraft.setModel_id(mId);
		if (aircraftRepo.findById(aircraft_Id) != null) {
			Aircraft tempAircraft = aircraftRepo.findById(aircraft_Id).get();
			if (tempAircraft.getAirline_id() != airline_id) {
				tempAircraft.setAirline_id(airline_id);
			}
			if (tempAircraft.getFlight_status() != flight_status) {
				tempAircraft.setFlight_status(flight_status);
			}

			aircraftRepo.save(tempAircraft);
			return "Updated aircraft successfully";
		}
		return "Aircraft doesn't exist";
	}

	// delete the aircraft based on aircraft id
	@DeleteMapping(path = "/deleteByID")
	public @ResponseBody String deleteAircraftById(@RequestParam Integer aId) {
		// This returns a JSON or XML with the users
		aircraftRepo.deleteById(aId);
		return "deletion done";
	}

}
