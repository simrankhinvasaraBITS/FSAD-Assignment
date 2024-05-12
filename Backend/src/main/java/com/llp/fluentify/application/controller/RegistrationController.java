package com.llp.fluentify.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.llp.fluentify.application.model.Professor;
import com.llp.fluentify.application.model.User;
import com.llp.fluentify.application.services.ProfessorService;
import com.llp.fluentify.application.services.UserService;

@RestController
public class RegistrationController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String currEmail = user.getEmail();
		String newID = getNewID();
		user.setUserid(newID);
		
		if(currEmail != null || !"".equals(currEmail))
		{
			User userObj = userService.fetchUserByEmail(currEmail);
			if(userObj != null)
			{
				throw new Exception("User with "+currEmail+" already exists !!!");
			}
		}
		User userObj = null;
		userObj = userService.saveUser(user);
		return userObj;
	}

	
	public String getNewID()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
	}
}