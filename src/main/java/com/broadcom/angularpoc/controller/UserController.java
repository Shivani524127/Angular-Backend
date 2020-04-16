package com.broadcom.angularpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.broadcom.angularpoc.entity.Login;
import com.broadcom.angularpoc.entity.User;
import com.broadcom.angularpoc.serviceimpl.UserRegistrationImpl;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserRegistrationImpl userRegistrationImpl;

	@GetMapping(value = "/hi")
	public String home() {
		return "hi";
	}

	/**
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/register")
	public ResponseEntity<User> signUp(@RequestBody User user) { 
		boolean valid = userRegistrationImpl.register(user);

		if (valid) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>((User) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param login
	 * @return
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<User> login(@RequestBody Login login) {
		User user = userRegistrationImpl.login(login.getEmail(), login.getPassword());
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else {
			user=null;		
		return new ResponseEntity<User>(user, HttpStatus.NOT_ACCEPTABLE);
		}
	}


}
