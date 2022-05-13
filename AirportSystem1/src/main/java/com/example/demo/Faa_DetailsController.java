package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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
@RequestMapping(path = "/faa")
public class Faa_DetailsController {

	@Autowired
	private Faa_DetailsRepo faa_DetailsRepo;

	// GET: get all Faa_Details
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Faa_Details> getAllFaa_Details() {
		// This returns a JSON or XML with the users
		return faa_DetailsRepo.findAll();
	}

	// GET: get model by Faa_Details Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Faa_Details> getFaa_DetailsById(@RequestParam Integer test_id) {
		// This returns a JSON or XML with the users
		return faa_DetailsRepo.findById(test_id);
	}

	// POST: Add a new Faa_Details
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewAircraft(@RequestParam("test_id") Integer test_id,
			@RequestParam("aircraft_id") Integer aircraft_id, @RequestParam("score") Float score,
			@RequestParam("date") Date date, @RequestParam("no_of_hours") Integer no_of_hours) {
		Faa_Details faa_Details = new Faa_Details();
		faa_Details.setTest_id(test_id);
		faa_Details.setAircraft_id(aircraft_id);
		faa_Details.setScore(score);
		faa_Details.setDate(date);
		faa_Details.setNo_of_hours(no_of_hours);
		faa_DetailsRepo.save(faa_Details);
		return "Added new Faa_Details successfully";
	}

	// update an existing model

	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody String updateAircraft(@RequestParam("test_id") Integer test_id,
			@RequestParam("score") Float score, @RequestParam("no_of_hours") Integer no_of_hours) {
		Faa_Details faa_Details = new Faa_Details();
		faa_Details.setTest_id(test_id);
		if (faa_DetailsRepo.findById(test_id) != null) {
			Faa_Details tempFaaDetails = faa_DetailsRepo.findById(test_id).get();
			if (tempFaaDetails.getScore() != score) {
				tempFaaDetails.setScore(score);
			}
			if (tempFaaDetails.getNo_of_hours() != no_of_hours) {
				tempFaaDetails.setNo_of_hours(no_of_hours);
			}

			faa_DetailsRepo.save(tempFaaDetails);
			return "Added new faa_Details successfully";
		}
		return "faa_Details doesn't exist";

	}

	// GET: get all Faa_Details which are above the given score
	@SuppressWarnings("unchecked")
	@GetMapping(path = "/allAboveThr")
	public @ResponseBody List<Faa_Details> getAllFaa_Details(@RequestParam("score") Float score) {
		// This returns a JSON or XML with the users

		Iterable<Faa_Details> faa_Details = faa_DetailsRepo.findAll();

		List<Faa_Details> list_faa = new ArrayList<Faa_Details>();

		// Iterable<Faa_Details> res_faa_Details ;
		for (Faa_Details faa_Details2 : faa_Details) {
			if (faa_Details2.getScore() >= score) {
				list_faa.add(faa_Details2);
			}
		}
//			res_faa_Details = (Iterable<Faa_Details>) list_faa.iterator();
		System.out.println(list_faa);
		Logger.getLogger(list_faa.toString());
		return list_faa;
	}
}
