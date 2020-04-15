package com.broadcom.angularpoc.service;

import com.broadcom.angularpoc.entity.User;
	
public interface UserRegistration {

	/**
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	/**
	 * @param email
	 * @param password
	 * @return
	 */
	public User login(String email, String password);

}
