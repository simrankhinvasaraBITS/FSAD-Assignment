package com.llp.fluentify.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llp.fluentify.application.model.User;
import com.llp.fluentify.application.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepo;
	
	@ApiOperation(value = "Save User Data", response = List.class)
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	
	@ApiOperation(value = "Update User Data", response = List.class)
	public User updateUserProfile(User user)
	{
		return userRepo.save(user);
	}
	
	@ApiOperation(value = "Get all User Data", response = List.class)
	public List<User> getAllUsers()
	{
		return (List<User>)userRepo.findAll();
	}
	
	public User fetchUserByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
	
	public User fetchUserByUsername(String username)
	{
		return userRepo.findByUsername(username);
	}
	
	public User fetchUserByEmailAndPassword(String email, String password)
	{
		return userRepo.findByEmailAndPassword(email, password);
	}
	
	public List<User> fetchProfileByEmail(String email)
	{
		return (List<User>)userRepo.findProfileByEmail(email);
	}
}