package com.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.model.CustomUserDetail;
import com.project.repositories.UserRepo;


@Service
public class CustomUserDetailServices implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepo.fetchUserByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new CustomUserDetail(user);
	}

}
