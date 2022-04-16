package com.training.ers.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.ers.utility.DBConnection;
import com.training.model.Reimbursement;

class EmployeeDAOImplTestJUnit {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPendingReimbursements() {
		String username = "test";
		Connection con = DBConnection.getConnection();
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
		
		assertTrue(reimbursements.size() > 0);
	}

	@Test
	void testGetResolvedReimbursements() {
		String username = "test";
		Connection con = DBConnection.getConnection();
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
		assertTrue(reimbursements.size() > 0);
	}

	@Test
	void testCreateExpense() {
		PreparedStatement stat = null;
		int rows = 0;
		Reimbursement reimbursement = new Reimbursement(99999, "travel", 10500,"test");
		Connection con = DBConnection.getConnection();
		
		try {
			stat = con.prepareStatement("insert into reimbursement values(default,?,default,?,default,default,?)");
			stat.setString(1, reimbursement.getR_type());
			stat.setLong(2, reimbursement.getAmount());
			stat.setString(3, reimbursement.getUsername());
			rows = stat.executeUpdate();
			System.out.println(rows + " create new expense added to database");
			
			
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(rows > 0);
	}

	@Test
	void testGetAllPending() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		System.out.println("Getting all pending reimbursements");
		Connection con = DBConnection.getConnection();
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
		assertTrue(reimbursements.size() > 0);
	}

	@Test
	void testGetAllResolved() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Connection con = DBConnection.getConnection();
		System.out.println("Getting all resolved reimbursements");
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
				reimbursement.setUsername(res.getString(7));			
				reimbursements.add(reimbursement);
			}
			
			res.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(reimbursements.size() > 0);
	}


}
