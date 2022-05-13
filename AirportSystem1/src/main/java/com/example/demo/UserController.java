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
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class UserController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	// private AirlinesRepo airlinesRepo;
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam Integer emp_id, @RequestParam String first_name,
			@RequestParam String middle_name, @RequestParam String last_name, @RequestParam String role,
			@RequestParam Date DOB, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User user = new User(emp_id, first_name, middle_name, last_name, role, DOB, password);
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users

		return userRepository.findAll();

	}

	@GetMapping(path = "/getbyID")
	public @ResponseBody Optional<User> getAllUserById(@RequestParam Integer id) {
		// This returns a JSON or XML with the users
		return userRepository.findById(id);
	}

	@DeleteMapping(path = "/delete")
	public @ResponseBody void deleteUserById(@RequestParam Integer id) {
		// This returns a JSON or XML with the users
		userRepository.deleteById(id);
//    return "delete successful";
	}

//   @GetMapping(path="/allEmp")
//   public @ResponseBody Iterable<Employee> getAllEmployees() {
//     // This returns a JSON or XML with the users
//     return EmployeeRepo.findAll();
//   }
//  
//  @GetMapping(path="/allA")
//  public @ResponseBody Iterable<Airlines> getAllAirlines() {
//    // This returns a JSON or XML with the users
//    return airlinesRepo.findAll();
//  } 
}
