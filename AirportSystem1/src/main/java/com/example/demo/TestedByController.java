package com.example.demo;

import java.util.ArrayList;
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
@RequestMapping(path = "/testby")
public class TestedByController {
	@Autowired
	private TestedByRepo tcrepo1;
	@Autowired
	Faa_DetailsController faa_DetailsController;

	// GET: get all airlines
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Tested_By> getAllTc() {
		// This returns a JSON or XML with the users
		return tcrepo1.findAll();
	}

	// POST: Add a new Airlines
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewTc(@RequestParam("ssn") Integer ssn, @RequestParam("test_id") Integer test_id) {
		Tested_By tc = new Tested_By();
		tc.setSsn(ssn);
		tc.setTest_id(test_id);

		tcrepo1.save(tc);
		return "Added new TC successfully";
	}

	// GET: get Airlines by airline Id
	@GetMapping(path = "/getByID")
	public @ResponseBody List<Integer> getTestedByById(@RequestParam Integer ssn) {
		// This returns a JSON or XML with the users
		// return tcrepo1.findById(ssn);
		return tcrepo1.testsDoneByTechnician(ssn);
	}

	@GetMapping(path = "/getSpecific")
	public @ResponseBody List<Tested_By> getTechOfSpecificAircraft(@RequestParam Integer aircraft_id) {
		// This returns a JSON or XML with the users

		Iterable<Faa_Details> all_faa = faa_DetailsController.getAllFaa_Details();

		Iterable<Tested_By> all_tested_by = tcrepo1.findAll();

		List<Faa_Details> list_faa = new ArrayList<Faa_Details>();

		for (Faa_Details faa_Details2 : all_faa) {
			if (faa_Details2.getAircraft_id() == aircraft_id) {
				System.out.println(faa_Details2.getAircraft_id());
				list_faa.add(faa_Details2);
			}
		}

		List<Tested_By> res = new ArrayList<Tested_By>();
		for (Faa_Details list_faa2 : list_faa) {
			for (Tested_By test2 : all_tested_by) {
				if (list_faa2.getTest_id() == test2.getTest_id()) {
					System.out.println(list_faa2.getTest_id());
					res.add(test2);
				}
			}
		}
		return res;
	}

}
