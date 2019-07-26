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
	public boolean ifExist(String email) {
				Login login =entityManager.find(Login.class, email);
				if(login!=null)
					return true;
				return false;
		
	}


	@Override
	public boolean register(User user, Login login) {
		try{
			System.out.println(user);
			System.out.println(login);
			entityManager.persist(user);
			entityManager.persist(login);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	@Override
	public List<Order> getUserOrders(User user){
		return entityManager.find(User.class, user.getEmail()).getOrders();
	}


	@Override
	public Login getLogin(String email) {
		return entityManager.find(Login.class, email);
	}
}
