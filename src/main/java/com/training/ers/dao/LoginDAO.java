package com.training.ers.dao;

import java.util.List;

import com.training.model.Manager;
import com.training.model.User;

public interface LoginDAO {
	
	public boolean register(User user, String type);
	//public boolean register(Manager manager);
	public boolean validate(String username, String password);
	public List<User> getUsers();
	public List<User> getUsersByUsername(String username);
	//public boolean isLoginExists(String username);
	//public boolean apply(Customer customer, long balance, String accountName);
	

}
