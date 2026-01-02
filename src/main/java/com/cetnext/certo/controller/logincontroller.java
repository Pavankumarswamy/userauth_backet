package com.cetnext.certo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetnext.certo.models.login;
import com.cetnext.certo.service.loginservice;

@RestController
@RequestMapping("api/v1")
public class logincontroller {
	@Autowired
	loginservice service;

	// Add single user
	@PostMapping("/signup")
	public String add(@RequestBody login l) {
		return service.add(l);
	}

	// Get all users
	@GetMapping("/users")
	public List<login> getall() {
		return service.getall();
	}

	// Delete user by email
	@DeleteMapping("/user/{email}")
	public String deleteByEmail(@PathVariable String email) {
		return service.deleteid(email);
	}

	// Get user by email
	@GetMapping("/user/{email}")
	public login getByEmail(@PathVariable String email) {
		return service.getbyemail(email);
	}

	// Update user by email
	@PutMapping("/user/{email}")
	public String updateByEmail(@RequestBody login l, @PathVariable String email) {
		return service.update(l, email);
	}

	// Add multiple users
	@PostMapping("/users")
	public List<login> addMultipleUsers(@RequestBody List<login> users) {
		return service.adddatas(users);
	}
}
