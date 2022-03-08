package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.ers.utility.DBConnection;
import com.training.model.User;

public class LoginDAOImpl implements LoginDAO {
	
	Connection con = DBConnection.getConnection();

	@Override
	public boolean register(User user) {
		System.out.println("Adding user : " + user.getUsername());
		PreparedStatement stat = null;
		con = DBConnection.getConnection();
		int rows = 0;

		try {
			//if(accounttype.equals("C")) {
			stat = con.prepareStatement("insert into users values(default,?,?,?,?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getGender());
			stat.setString(4, user.getNotification());
			stat.setString(5, user.getQualification());
			
			rows = stat.executeUpdate();
			System.out.println(rows + " user added to database");
			/*
			stat = null;
			rows = 0;
			stat = con.prepareStatement("insert into login values(default,?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			rows = stat.executeUpdate();
			System.out.println(rows + " user registered successfully");
			} else {
				stat = con.prepareStatement("insert into employees values(default,?,?,?,default)");
				stat.setString(1, firstname);
				stat.setString(2, username);
				stat.setString(3, password);
				rows = stat.executeUpdate();
				System.out.println(rows + " employee added to database");
				
				stat = null;
				rows = 0;
				stat = con.prepareStatement("insert into login values(default,?,?)");
				stat.setString(1, username);
				stat.setString(2, password);
				rows = stat.executeUpdate();
				System.out.println(rows + " user registered successfully");
			}*/
			
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean validate(String username, String password) {
		
		System.out.println("Searching for user with username : " + username);
		PreparedStatement stat;
		boolean userValid = false;
		con = DBConnection.getConnection();
		User user = new User();
		List<User> users = new ArrayList<User>();

		try {
			stat = con.prepareStatement("select * from users where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			
			while (res.next()) {
				user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				users.add(user);
				
			}
			/*
			stat = con.prepareStatement("select * from users where username = ? and password = ?");
			stat.setString(1, username);
			stat.setString(2, password);
			//stat.setString(3, "Y");
			
			res = stat.executeQuery();
			
			while (res.next()) {
				user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setUsername(res.getString(3));
				user.setPassword(res.getString(4));
				user.setGender(res.getString(5));
				user.setNotification(res.getString(6));
				user.setQualification(res.getString(7));
				users.add(user);
			}
			*/
			//System.out.println(customer.getStatus());
			res.close();
			stat.close();
			con.close();
			/*
			if(customer.getStatus() != null && customer.getStatus().equals("N")) {
				//System.out.println("Account has not been approved yet. Administrator will update in a timely manner.");
				return false;
			}*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(users.size() == 0) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<User> getUsers() {
		con = DBConnection.getConnection();
		System.out.println("Getting all users");
		List<User> users = new ArrayList<User>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from users");
			while(res.next()) {
				User user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setGender(res.getString(4));
				user.setNotification(res.getString(5));
				user.setQualification(res.getString(6));
				users.add(user);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<User> getUsersByUsername(String username) {
		con = DBConnection.getConnection();
		System.out.println("Getting all users with username : "+username);
		List<User> users = new ArrayList<User>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from users where username = '"+username+"'");
			while(res.next()) {
				User user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setGender(res.getString(4));
				user.setNotification(res.getString(5));
				user.setQualification(res.getString(6));
				users.add(user);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/*
	
	public boolean isLoginExists(String username) {
		boolean loginExists = false;
		PreparedStatement stat;
		con = DBConnection.getConnection();

		try {
			stat = con.prepareStatement("select * from login where username = ? ");
			stat.setString(1, username);

			ResultSet res = stat.executeQuery();
			loginExists = res.next();
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginExists;
	}

	@Override
	public boolean apply(Customer customer, long balance, String accountName) {
		System.out.println("Applying for account by : " + customer.getFirstname());
		PreparedStatement stat = null;
		con = DBConnection.getConnection();
		int rows = 0;

		try {
			stat = con.prepareStatement("insert into apply values(default,?,?,?,?,?,?)");
			stat.setString(1, customer.getFirstname());
			stat.setString(2, customer.getUsername());
			stat.setString(3, customer.getPassword());
			stat.setLong(4, balance);
			stat.setString(5, customer.getAccounttype());
			stat.setString(6, accountName);
			rows = stat.executeUpdate();
			System.out.println(rows + " account application added to database");
			
			
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	*/
	

}
