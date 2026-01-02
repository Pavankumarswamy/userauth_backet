package com.cetnext.certo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.certo.models.login;
import com.cetnext.certo.repo.loginrepo;
import com.cetnext.certo.service.loginservice;

import jakarta.transaction.Transactional;

@Service
public class loginserviceimplentatio implements loginservice {

	@Autowired
	loginrepo repo;

	@Override
	public String add(login user) {
		try {
			repo.save(user);
			return "User added successfully!";
		} catch (Exception e) {
			return "Error adding user: " + e.getMessage();
		}
	}

	@Override
	public List<login> getall() {
		return repo.findAll();
	}
	@Transactional
	@Override
	public String deleteid(String email) {
		try {
			Optional<login> user = repo.findByEmail(email);

			if (user.isPresent()) {
				repo.delete(user.get());
				return "User with email " + email + " deleted successfully!";
			} else {
				return "User with email " + email + " not found!";
			}
		} catch (Exception e) {
			return "Error deleting user: " + e.getMessage();
		}
	}

	@Override
	public login getbyemail(String email) {
		try {
			return repo.findByEmail(email).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String update(login l, String email) {
		Optional<login> existingUser = repo.findByEmail(email);
		login user = existingUser.get();
		user.setUsername(l.getUsername());
		user.setEmail(l.getEmail());
		user.setPassword(l.getPassword());
		user.setAcceptedTermsAndConditions(l.getAcceptedTermsAndConditions());
		user.setAddress(l.getAddress());
		repo.save(user);
		return "User updated successfully!";
	}

	@Override
	public List<login> adddatas(List<login> users) {
		try {
			return repo.saveAll(users);
		} catch (Exception e) {
			return null;
		}
	}
}
