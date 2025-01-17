package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.IAdminService;
import com.app.wrapper.WrapperUpdate;


@CrossOrigin(origins="http://localhost:4200",allowedHeaders="application/json")
@RequestMapping("/Admin")
@RestController
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	
	
	@PostMapping("/addProduct")
	public boolean addProduct(@RequestBody Product product){
		System.out.println(product);
		 return service.addProduct(product);
				
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProduct(@RequestParam int id) {
		service.deleteProduct(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody WrapperUpdate product,@PathVariable String id) {
		System.out.println(product);
		System.out.println(id);
		return  new ResponseEntity<Product>(service.updateProduct(product,id),HttpStatus.ACCEPTED);
		
	}

	
		
}
