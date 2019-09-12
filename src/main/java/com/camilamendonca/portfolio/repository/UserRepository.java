package com.camilamendonca.portfolio.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.camilamendonca.portfolio.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findUserByUsername(String username) throws UsernameNotFoundException;

}
