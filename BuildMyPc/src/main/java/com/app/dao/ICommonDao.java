package com.app.dao;

import com.app.pojos.Login;
import com.app.pojos.User;

public interface ICommonDao {
	public boolean signUp(User user,Login login);
	
	public Login getLogin(String email);

	
}
