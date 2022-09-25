package com.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.exceptions.ResourceNotFoundException;
import com.project.repositories.UserRepo;
import com.project.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public User addUser(User user) {
		String newPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
		user.setPassword(newPass);
		return this.userRepo.save(user);
	}

	@Override
	public User fetchUserByEmail(String email) {
		User user = userRepo.fetchUserByEmail(email);
		return user;
	}

	@Override
	public User fetchUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return user;
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> users = (List<User>)this.userRepo.findAll(); 
		return users;
		
		//for DTO class
		//List<userDto> userDtos = users.stream().map(user -> this.modelMapper.map(user, userDto.class)).collect(Collectors.toList());
	}

	@Override
	public User updateUser(User user, Integer userId) {
		User oldUser = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());
		oldUser.setContactNo(user.getContactNo());
		oldUser.setAddress1(user.getAddress1());
		oldUser.setAddress2(user.getAddress2());
		oldUser.setCity(user.getCity());
		oldUser.setState(user.getState());
		oldUser.setPincode(user.getPincode());
		oldUser.setUserRole(user.getUserRole());
		
		User updatedUser = this.userRepo.save(oldUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}
	
}
