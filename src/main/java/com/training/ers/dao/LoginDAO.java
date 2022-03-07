package com.training.ers.dao;

import com.training.model.User;

public interface LoginDAO {
	
	public boolean register(User user);
	public boolean validate(String username, String password);
	//public boolean isLoginExists(String username);
	//public boolean apply(Customer customer, long balance, String accountName);
	

}
