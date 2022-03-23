package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.ers.utility.DBConnection;
import com.training.model.Manager;
import com.training.model.User;

public class LoginDAOImpl implements LoginDAO {
	
	private static Logger logger = Logger.getLogger(LoginDAOImpl.class);	
	Connection con = DBConnection.getConnection();
	List<User> users = new ArrayList<User>();
	List<Manager> managers = new ArrayList<Manager>();

	@Override
	public boolean register(User user, String type) {
		System.out.println("Adding user : " + user.getUsername());
		PreparedStatement stat = null;
		con = DBConnection.getConnection();
		int rows = 0;

		try {
			stat = con.prepareStatement("insert into login values(default,?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			rows = stat.executeUpdate();
			System.out.println(rows + " user added to login table successfully");
			
			int login_id = 0;
			
			stat = con.prepareStatement("select id from login where username = ?");
			stat.setString(1, user.getUsername());
			ResultSet res = stat.executeQuery();
			while(res.next()) {
				User user1 = new User();
				user1.setUserId(res.getInt(1));
				users.add(user1);
				login_id = user1.getUserId();
			}
			
			if(type != null) {
			stat = con.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getFirstname());
			stat.setString(4, user.getLastname());
			stat.setString(5, user.getEmail());
			stat.setInt(6, login_id);
			stat.setString(7, type.substring(0,1));
			
			rows = stat.executeUpdate();
			System.out.println(rows + " user added to database");
			} else {
				stat = con.prepareStatement("insert into users values(default,?,?,?,?,?,?)");
				stat.setString(1, user.getUsername());
				stat.setString(2, user.getPassword());
				stat.setString(3, user.getFirstname());
				stat.setString(4, user.getLastname());
				stat.setString(5, user.getEmail());
				stat.setInt(6, login_id);
				
				rows = stat.executeUpdate();
				System.out.println(rows + " user added to database");
				
			}
		
			
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			logger.info(user.getUsername()+" has failed to register at :"+new java.util.Date());
			return false;
		}
		else {
			logger.info(user.getUsername()+" has registered at :"+new java.util.Date());
			return true;
		}
	}
	/*
	@Override
	public boolean register(Manager manager) {
		System.out.println("Adding manager : " + manager.getUsername());
		PreparedStatement stat = null;
		con = DBConnection.getConnection();
		int rows = 0;

		try {
			//if(accounttype.equals("C")) {
			stat = con.prepareStatement("insert into login values(default,?,?)");
			stat.setString(1, manager.getUsername());
			stat.setString(2, manager.getPassword());
			rows = stat.executeUpdate();
			System.out.println(rows + " manager added to login table successfully");
			
			int login_id = 0;
			
			stat = con.prepareStatement("select id from login where username = ?");
			stat.setString(1, manager.getUsername());
			ResultSet res = stat.executeQuery();
			while(res.next()) {
				Manager manager1 = new Manager();
				manager1.setManagerId(res.getInt(1));
				managers.add(manager1);
				login_id = manager1.getManagerId();
			}
			
			
			stat = con.prepareStatement("insert into managers values(default,?,?,?,?,?,?)");
			stat.setString(1, manager.getUsername());
			stat.setString(2, manager.getPassword());
			stat.setString(3, manager.getFirstname());
			stat.setString(4, manager.getLastname());
			stat.setString(5, manager.getEmail());
			stat.setInt(6, login_id);
			
			rows = stat.executeUpdate();
			System.out.println(rows + " manager added to database");
			
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			logger.info(manager.getUsername()+" has failed to register at :"+new java.util.Date());
			return false;
		}
		else {
			logger.info(manager.getUsername()+" has registered at :"+new java.util.Date());
			return true;
		}
	}*/

	@Override
	public boolean validate(String username, String password) {
		
		System.out.println("Searching for user with username : " + username);
		PreparedStatement stat, stat2;
		boolean userValid = false;
		con = DBConnection.getConnection();
		User user = new User();
		List<User> users = new ArrayList<User>();
		Manager manager = new Manager();
		List<Manager> managers = new ArrayList<Manager>();

		try {
			stat2 = con.prepareStatement("select accounttype from users where username = ? and password = ? ");
			stat2.setString(1, username);
			stat2.setString(2, password);
			
			ResultSet res2 = stat2.executeQuery();
			
			while (res2.next()) {
				user = new User();
				user.setAccounttype(res2.getString(1));
				users.add(user);
				
			}
			String type = user.getAccounttype();
			System.out.println(type);
			
			if(type.equals("E")) {
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
			} else {
				
				stat = con.prepareStatement("select * from managers where username = ? and password = ? ");
				stat.setString(1, username);
				stat.setString(2, password);
				
				ResultSet res = stat.executeQuery();
				
				while (res.next()) {
					manager = new Manager();
					manager.setManagerId(res.getInt(1));
					manager.setUsername(res.getString(2));
					manager.setPassword(res.getString(3));
					managers.add(manager);
					
				}
			}
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
			logger.info(username+" has failed to login at :"+new java.util.Date());
			return false;
		}
		logger.info(user.getUsername()+" has logged in at :"+new java.util.Date());
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
				user.setFirstname(res.getString(4));
				user.setLastname(res.getString(5));
				user.setEmail(res.getString(6));
				user.setLogin_id(res.getInt(7));
				users.add(user);
				
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("User has viewed all users at :"+new java.util.Date());
		return users;
	}
	
	@Override
	public List<User> getEmployees() {
		con = DBConnection.getConnection();
		System.out.println("Getting all employees");
		List<User> users = new ArrayList<User>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from users where accounttype = 'E'");
			while(res.next()) {
				User user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setFirstname(res.getString(4));
				user.setLastname(res.getString(5));
				user.setEmail(res.getString(6));
				user.setLogin_id(res.getInt(7));
				users.add(user);
				
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("User has viewed all employees at :"+new java.util.Date());
		return users;
	}

	@Override
	public List<User> getUsersByUsername(String username) {
		con = DBConnection.getConnection();
		System.out.println("Getting all users with username : "+username);
		List<User> users = new ArrayList<User>();
		String user1 = "";
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from users where username = '"+username+"'");
			while(res.next()) {
				User user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setFirstname(res.getString(4));
				user.setLastname(res.getString(5));
				user.setEmail(res.getString(6));
				user.setLogin_id(res.getInt(7));
				users.add(user);
				user1 = user.getUsername();			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("User has viewed username : "+user1+ " at :"+new java.util.Date());
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
