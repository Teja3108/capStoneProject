package com.example.demo.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.pojo.Admin;
import com.example.demo.pojo.Citizens;
import com.example.demo.pojo.LoginRequest;
import com.example.demo.pojo.User;
import com.example.demo.Repo.AdminRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Repo.CitizensRepo;
import com.example.demo.Exception.AdminNotFoundException;
import com.example.demo.Exception.CitizenNotFoundException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.pojo.SuccessResponse;
@RestController
public class RestApiController {
	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private CitizensRepo citiRepo;
	// Login endpoint
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		// Retrieve the username and password from the request body
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		// Here, you can implement your authentication logic, such as checking if the user exists in the database
		// and verifying the password. For simplicity, we'll use a hardcoded username and password.
		if ("admin".equals(username) && "Pass@word123".equals(password)) {
			// If authentication is successful, return a success response
			return ResponseEntity.ok().body("Login Successful");
		} else {
			// If authentication fails, return an error response
			return ResponseEntity.badRequest().body("Invalid credentials");
		}}
	// Admin
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/admin")
	public Iterable<Admin> getAdmin() {
		return adminrepo.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable("id") Integer id) {
		Optional<Admin> optAdmin = adminrepo.findById(id);
		if (optAdmin.isEmpty()) {
			throw new AdminNotFoundException(id);
		}
		return optAdmin.get();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/admin")
	public Admin create(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/admin")
	public Admin update(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/admin/{id}")
	public void deleteadmin(@PathVariable("id") Integer id) {
		adminrepo.deleteById(id);
	}
	// User
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user")
	public Iterable<User> getUser() {
		return userrepo.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		Optional<User> optUser = userrepo.findById(id);
		if (optUser.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		return optUser.get();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user")
	public User create(@RequestBody User user) {
		return userrepo.save(user);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/user")
	public User update(@RequestBody User user) {
		return userrepo.save(user);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/user/{id}")
	public void deleteuser(@PathVariable("id") Integer id) {
		userrepo.deleteById(id);
	}
	// Citizens
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/citizens")
	public Iterable<Citizens> getCitizens() {
		return citiRepo.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/citizens/{id}")
	public Citizens getCiti(@PathVariable("id") Integer id) {
		Optional<Citizens> optCiti = citiRepo.findById(id);
		if (optCiti.isEmpty()) {
			throw new CitizenNotFoundException(id);
		}
		return optCiti.get();
	}
	// Registration endpoint with check for existing citizen
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/citizens")
	public ResponseEntity<?> create(@RequestBody Citizens citi) {
		// Check if a citizen with the same email and name already exists
		boolean citizenExists = citiRepo.existsByEmailidAndName(citi.getEmailid(), citi.getName());
		if (citizenExists) {
			return ResponseEntity.badRequest().body("User with the same email and name already exists!");
		}
		// If no existing citizen, proceed with registration
		return ResponseEntity.ok(citiRepo.save(citi));
	}
	// Update Adhar number endpoint
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/citizens/{id}/adhar")
	public ResponseEntity<?> addAdharNumber(@PathVariable("id") Integer id, @RequestBody String adharNumber) {
		Optional<Citizens> optCiti = citiRepo.findById(id);
		if (optCiti.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Citizens citi = optCiti.get();
		citi.setAdharNumber(adharNumber);
		citiRepo.save(citi);
		SuccessResponse response = new SuccessResponse("Adhar number added successfully!");
		return ResponseEntity.ok(response);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/citizens")
	public Citizens update(@RequestBody Citizens citi) {
		return citiRepo.save(citi);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/citizens/{id}")
	public void deleteciti(@PathVariable("id") Integer id) {
		citiRepo.deleteById(id);
	}
}
