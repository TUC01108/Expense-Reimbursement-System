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
import com.training.model.Reimbursement;
import com.training.model.User;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);	
	Connection con = DBConnection.getConnection();
	List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

	@Override
	public List<Reimbursement> getPendingReimbursements(String username) {
		con = DBConnection.getConnection();
		System.out.println("Getting all pending reimbursements for user : "+username);
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursement where username = '"+username+"' and status = 'Created'");
			while(res.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementId(res.getInt(1));
				reimbursement.setR_type(res.getString(2));
				reimbursement.setStatus(res.getString(3));
				reimbursement.setAmount(res.getLong(4));
				reimbursement.setCreated_date(res.getDate(5));
				reimbursement.setSubmitted_date(res.getDate(6));
				reimbursement.setUsername(res.getString(7));			
				reimbursements.add(reimbursement);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info(username+" viewed all pending reimbursements at :"+new java.util.Date());

		return reimbursements;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursements(String username) {
		con = DBConnection.getConnection();
		System.out.println("Getting all resolved reimbursements for user : "+username);
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursement where username = '"+username+"' and status = 'Resolved'");
			while(res.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementId(res.getInt(1));
				reimbursement.setR_type(res.getString(2));
				reimbursement.setStatus(res.getString(3));
				reimbursement.setAmount(res.getLong(4));
				reimbursement.setCreated_date(res.getDate(5));
				reimbursement.setSubmitted_date(res.getDate(6));
				reimbursements.add(reimbursement);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info(username+" viewed all resolved reimbursements at :"+new java.util.Date());

		return reimbursements;
	}

	@Override
	public boolean createExpense(Reimbursement reimbursement) {
		System.out.println("Creating a new Expense for : "); //+ user.getFirstname());
		PreparedStatement stat = null;
		con = DBConnection.getConnection();
		int rows = 0;

		try {
			stat = con.prepareStatement("insert into reimbursement values(default,?,default,?,default,default,?)");
			stat.setString(1, reimbursement.getR_type());
			stat.setLong(2, reimbursement.getAmount());
			stat.setString(3, "thomas");
			rows = stat.executeUpdate();
			System.out.println(rows + " create new expense added to database");
			
			
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
	public boolean typeIs(String username, String password) {
		// RETURN- true if employee, if MANAGER- false
		
		PreparedStatement stat2;
		boolean userValid = false;
		con = DBConnection.getConnection();
		User user = new User();
		List<User> users = new ArrayList<User>();
		
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
			
			if(type.equals("E")) 
				return true;
			 else
				return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} return false;

}

	@Override
	public List<Reimbursement> getAllPending() {
		con = DBConnection.getConnection();
		System.out.println("Getting all pending reimbursements");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursement where status = 'Created'");
			while(res.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementId(res.getInt(1));
				reimbursement.setR_type(res.getString(2));
				reimbursement.setStatus(res.getString(3));
				reimbursement.setAmount(res.getLong(4));
				reimbursement.setCreated_date(res.getDate(5));
				reimbursement.setSubmitted_date(res.getDate(6));
				reimbursement.setUsername(res.getString(7));			
				reimbursements.add(reimbursement);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Manager viewed all pending reimbursements at :"+new java.util.Date());

		return reimbursements;
	}
	
	@Override
	public List<Reimbursement> getAllResolved() {
		con = DBConnection.getConnection();
		System.out.println("Getting all resolved reimbursements");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		Statement stat = null;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursement where status = 'Resolved'");
			while(res.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementId(res.getInt(1));
				reimbursement.setR_type(res.getString(2));
				reimbursement.setStatus(res.getString(3));
				reimbursement.setAmount(res.getLong(4));
				reimbursement.setCreated_date(res.getDate(5));
				reimbursement.setSubmitted_date(res.getDate(6));
				reimbursements.add(reimbursement);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Manager viewed all resolved reimbursements at :"+new java.util.Date());

		return reimbursements;
	}
	
}
