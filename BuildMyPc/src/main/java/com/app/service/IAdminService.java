package com.app.service;

import com.app.pojos.Product;
import com.app.wrapper.WrapperUpdate;

public interface IAdminService {

	public boolean addProduct(Product product);

	public void deleteProduct(int id);

	public Product updateProduct(WrapperUpdate product, String id);

	
}
