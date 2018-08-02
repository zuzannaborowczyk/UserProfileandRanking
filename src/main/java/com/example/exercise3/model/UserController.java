package com.example.exercise3.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exercise3.service.UserService;

@Controller
@ResponseBody
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/usersById", method = RequestMethod.GET)
	public UserTO findById(@RequestParam("id") long id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/user/{id}/life-motto", method = RequestMethod.PUT)
	public UserTO editLifeMotto(@RequestParam("newLifeMotto") String newLifeMotto, @PathVariable("id") long id) {
		 return userService.changeLifeMotto(id, newLifeMotto);
		 
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserTO> searchUsersByParameters(
			@RequestParam(value = "firstName", required = false)String firstName, 
			@RequestParam(value = "lastName", required = false)String lastName,
			@RequestParam(value = "email", required = false)String email) {
		return userService.searchUsersByParameters(firstName, lastName, email);
		
	}
	
	
}
