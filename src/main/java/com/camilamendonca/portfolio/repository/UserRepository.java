package com.camilamendonca.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.camilamendonca.portfolio.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	public User findByUsername(String username) throws UsernameNotFoundException;

}
