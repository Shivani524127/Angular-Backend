package com.broadcom.angularpoc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.angularpoc.entity.User;
import com.broadcom.angularpoc.repository.UserRepository;
import com.broadcom.angularpoc.service.UserRegistration;

@Service
public class UserRegistrationImpl implements UserRegistration{

	@Autowired
	private UserRepository userRepository;

	public boolean register(User user) {
		List<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser.isEmpty()) {
			userRepository.save(user);
			return true;
		}
		else {
			return false;
		}

	}

	public User login(String email, String password) {

		List<User> users = userRepository.findByEmail(email);
		if(!users.isEmpty()) {
			if (users.get(0).getPassword().equals(password)) {
				return users.get(0);
			} 
		}
		return null;
			
	}


}
