package com.project.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.entity.User;

public interface UserService {

	//Create
	User addUser(User user);

	//Read
	User fetchUserByEmail(String email);

	//Read
	User fetchUserById(Integer userId);
	
	//Read
	List<User> fetchAllUsers();
	
	//Update
	User updateUser(User user, Integer userId);
	
	//Delete
	void deleteUser(Integer userId);
}
