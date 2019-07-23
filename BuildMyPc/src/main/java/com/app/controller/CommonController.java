package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IItemRepo;
import com.app.dao.ILoginRepo;
import com.app.dao.IOrderRepo;
import com.app.dao.IProductRepo;
import com.app.dao.IUserRepo;
import com.app.other.EnumRole;
import com.app.pojos.Login;
import com.app.pojos.User;


//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/common")
public class CommonController {
	@Autowired
	private IItemRepo item;
	@Autowired
	private ILoginRepo login;
	@Autowired
	private IOrderRepo order;
	@Autowired
	private IUserRepo user;
	@Autowired
	private IProductRepo product;
	
	@GetMapping("/test")
	public Login text(){
		System.out.println("in test");
		return login.findByEmail("ajay@gmail.com");
		//return product.findByCategory(EnumCategory.HDD);
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
