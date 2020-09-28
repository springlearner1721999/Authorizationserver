package com.sagar.authenticationserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.authenticationserver.model.User;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByusername(String Username);

}
