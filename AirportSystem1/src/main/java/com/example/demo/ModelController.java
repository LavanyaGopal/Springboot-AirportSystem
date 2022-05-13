package com.example.demo;

import java.util.Optional;

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
@RequestMapping(path = "/model")
public class ModelController {

	@Autowired
	private ModelRepo modelRepo;

	// GET: get all models
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Model> getAllModels() {
		// This returns a JSON or XML with the users
		return modelRepo.findAll();
	}

	// GET: get model by model Id
	@GetMapping(path = "/getByID")
	public @ResponseBody Optional<Model> getModelById(@RequestParam Integer mId) {
		// This returns a JSON or XML with the users
		return modelRepo.findById(mId);
	}

	// POST: Add a new model
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewModel(@RequestParam("mId") Integer mId, @RequestParam("weight") Integer weight,
			@RequestParam("capacity") Integer capacity) {
		Model model = new Model();
		model.setModel_id(mId);
		model.setWeight(weight);
		model.setCapacity(capacity);
		modelRepo.save(model);
		return "Added new model successfully";
	}

	// update an existing model

	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody String updateModel(@RequestParam("mId") Integer mId, @RequestParam("weight") Integer weight,
			@RequestParam("capacity") Integer capacity) {
//		Model model = new Model();
//		model.setModel_id(mId);
		if (modelRepo.findById(mId) != null) {
			Model tempModel = modelRepo.findById(mId).get();
			if (tempModel.getWeight() != weight) {
				tempModel.setWeight(weight);
			}
			if (tempModel.getCapacity() != capacity) {
				tempModel.setCapacity(capacity);
			}

			modelRepo.save(tempModel);
			return "Added new model successfully";
		}
		return "Model doesn't exist";

	}
}
