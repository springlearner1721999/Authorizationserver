package com.sagar.authenticationserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sagar.authenticationserver.model.AuthUserDetail;
import com.sagar.authenticationserver.model.User;
import com.sagar.authenticationserver.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userDetail = userDetailsRepository.findByusername(username);
		userDetail.orElseThrow((()-> new UsernameNotFoundException("User not found" + username)));
		
		UserDetails userdetails = new AuthUserDetail(userDetail.get());
	
		
		return userdetails;
	}

}
