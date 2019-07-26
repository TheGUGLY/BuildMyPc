package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Login;
import com.app.pojos.User;
import com.app.service.ICommonService;


//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/common")
public class CommonController {
	@Autowired
	private ICommonService service;
	
	@PostMapping("/test")
	public User text(@RequestBody User user ){
		System.out.println("in test");
		return service.getUser(user);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Login login){
		String role = service.login(login);
		if(role == null){
			ResponseEntity.status(HttpStatus.NOT_FOUND);
			return "User Doesn't Exist.";
		}
		ResponseEntity.status(HttpStatus.FOUND);
		return role; 
	}
	@PostMapping("/register")
	public boolean registerUser(@RequestBody User user,@RequestBody String password){
		
		return service.signUp(user,password);
	}
	
	
}
