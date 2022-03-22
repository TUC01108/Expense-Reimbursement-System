package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.ers.utility.DBConnection;

public class ManagerDAOImpl implements ManagerDAO {
	
	Connection con = DBConnection.getConnection();
	
	@Override
	public boolean approveApply(int reimbursementId) {
		con = DBConnection.getConnection();
		PreparedStatement stat = null;
		int rows = 0;
		
		try {
			
			stat = con.prepareStatement("update reimbursement set status = 'Resolved' where reimbursementid = ? ");
			stat.setInt(1, reimbursementId);

			rows = stat.executeUpdate();
			
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean rejectApply(int reimbursementId) {
		con = DBConnection.getConnection();
		PreparedStatement stat = null;
		int rows = 0;
		
		try {
			stat = con.prepareStatement("delete from reimbursement where reimbursementId = ? ");
			stat.setInt(1, reimbursementId);

			rows = stat.executeUpdate();
			
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

}
