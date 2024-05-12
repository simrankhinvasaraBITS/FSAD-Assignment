package com.llp.fluentify.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.llp.fluentify.application.model.Professor;
import com.llp.fluentify.application.model.User;
import com.llp.fluentify.application.services.ProfessorService;
import com.llp.fluentify.application.services.UserService;

@RestController
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/")
    public String welcomeMessage()
    {
    	return "Welcome to Language Learning Platform - Fluentify !!!";
    }
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String currEmail = user.getEmail();
		String currPassword = user.getPassword();
		
		User userObj = null;
		if(currEmail != null && currPassword != null)
		{
			userObj = userService.fetchUserByEmailAndPassword(currEmail, currPassword);
		}
		if(userObj == null)
		{
			throw new Exception("User does not exists!!! Please enter valid credentials...");
		}		
		return userObj;
	}
}