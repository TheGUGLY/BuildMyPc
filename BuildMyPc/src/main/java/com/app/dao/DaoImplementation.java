package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Login;
import com.app.pojos.Order;
import com.app.pojos.User;

@Repository
public class DaoImplementation implements IAdminDao,IUserDao,ICommonDao{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User getUser(User user) {
		return entityManager.find(User.class, user.getEmail());
	}
	
	
	@Override
	public boolean signUp(User user, Login login) {
		try{
			entityManager.persist(user);
			entityManager.persist(login);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public boolean signUpTest(User user) {
		try{
			entityManager.persist(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<Order> getUserOrders(User user){
		return entityManager.find(User.class, user.getEmail()).getOrders();
	}
}
