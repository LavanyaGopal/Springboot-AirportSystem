package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Controller // This means that this class is a Controller
@RequestMapping(path = "/exp")
public class ExpertInController {
	@Autowired
	private ExpertInRepo tcrepo1;

	// GET: get all airlines
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Expert_In> getAllemp() {
		// This returns a JSON or XML with the users
		return tcrepo1.findAll();
	}

	// POST: Add a new Airlines
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewTc(@RequestParam("ssn") Integer ssn, @RequestParam("model_id") Integer model_id) {
		Expert_In tc = new Expert_In();
		tc.setSsn(ssn);
		tc.setModel_id(model_id);
		tcrepo1.save(tc);
		return "Added new TC successfully";
	}

	// GET: get Airlines by airline Id
	@GetMapping(path = "/getByID")
	public @ResponseBody List<Integer> getExpertInBySsn(@RequestParam("ssn") Integer ssn) {
		// This returns a JSON or XML with the users

		return tcrepo1.listExpertizeOfTechnician1(ssn);
		// return tcrepo1.findById(ssn);
	}
	// need to implement custom getByID - as it has a composite key
	// https://attacomsian.com/blog/spring-data-jpa-composite-primary-key

	// update not necessary for this table
	@PutMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody String updateExpertIn(@RequestParam("ssn") Integer ssn,
			@RequestParam("model_id") Integer model_id) {
//			Expert_InID exp1 = new Expert_InID();
//			exp1.setSsn(ssn);
//			exp1.setModel_id(model_id);

		Expert_In expert_In = new Expert_In();
		expert_In.setModel_id(model_id);
		expert_In.setSsn(ssn);

		// tcrepo1.insertNewTech(ssn,model_id);
		tcrepo1.save(expert_In);
		return "Updated expert successfully";
//
//			if (tcrepo1.findById(expert_In) != null) {
//				Expert_In tc1 = tcrepo1.findById(ssn, model_id).get();
//				if (tc1.getModel_id() != model_id) {
//					tc1.setModel_id(model_id) ;
//				}
//				tcrepo1.save(tc1);
//				return "Updated expert successfully";
//			}
//			return "TC doesn't exist";

	}

}
