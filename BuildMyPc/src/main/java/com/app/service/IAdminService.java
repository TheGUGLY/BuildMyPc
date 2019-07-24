package com.app.service;

import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.User;

public interface IAdminService {
	User getUser(User user);
	List<Order> getUserOrders(User user);
	boolean signUp(User user, String password);
	boolean signUpTest(User user);
}
