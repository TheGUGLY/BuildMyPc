package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.other.EnumCategory;
import com.app.pojos.Product;

public interface IProductRepo extends JpaRepository<Product,Integer>{
	List<Product> findByCategory(EnumCategory category);
}