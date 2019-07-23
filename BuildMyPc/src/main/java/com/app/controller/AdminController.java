package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IItemRepo;
import com.app.dao.ILoginRepo;
import com.app.dao.IOrderRepo;
import com.app.dao.IProductRepo;
import com.app.dao.IUserRepo;


//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RequestMapping("/Admin")
@RestController
public class AdminController {
	
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
	
	@GetMapping
	public String Testme(){
		return "Tested";
	}
		
}
