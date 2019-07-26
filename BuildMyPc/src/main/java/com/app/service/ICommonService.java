package com.app.service;

import java.util.List;

import com.app.pojos.Login;
import com.app.pojos.Order;
import com.app.pojos.User;

public interface ICommonService {
	
	
	public String login(Login login);
	
	User getUser(User user);
	
	List<Order> getUserOrders(User user);
	
	boolean signUp(User user, String password);
}
