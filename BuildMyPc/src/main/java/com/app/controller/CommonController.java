package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ILoginRepo;
import com.app.other.EnumCategory;
import com.app.other.EnumRole;
import com.app.pojos.Login;
import com.app.pojos.User;


//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/common")
public class CommonController {
	@Autowired
	private ILoginRepo dao; 

	@PostMapping
	public String addMovie(@RequestBody Login m) {
		System.out.println("rest server : add movie " + m);
		dao.save(m);
		return "Movie added";
	}
	@GetMapping
	public String text(){
		System.out.println("in test");
		return "tested";
		//return dao.fetchCategory();
	}
	@PostMapping("/login")
	public EnumRole logIn(@RequestBody Login l){
		EnumRole role =EnumRole.ADMIN;//= dao.loginUser(l);
		//User u = dao.fetchUser(l);
		return role;
	}
	
	@PostMapping("/SignUp")
	public boolean signUp(@RequestBody User u){
		
		//dao.signUp(u,new Login(u.getEmail(),password,EnumRole.USER));
		
		return false;
	}

}
