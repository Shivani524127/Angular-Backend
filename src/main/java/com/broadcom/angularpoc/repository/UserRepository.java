package com.broadcom.angularpoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.broadcom.angularpoc.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * @param email
	 * @return
	 */
	@Query
	public List<User> findByEmail(String email);

}
