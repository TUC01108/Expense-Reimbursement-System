package com.training.ers.dao;

import java.sql.Connection;
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
	
	private static Logger logger = Logger.getLogger(LoginDAOImpl.class);	
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
			ResultSet res = stat.executeQuery("select * from reimbursement where username = '"+username+"' and status = 'pending'");
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
			ResultSet res = stat.executeQuery("select * from reimbursement where username = '"+username+"' and status = 'resolved'");
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
		return reimbursements;
	}

}
