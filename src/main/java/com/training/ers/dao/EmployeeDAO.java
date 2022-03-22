package com.training.ers.dao;

import java.util.List;

import com.training.model.Reimbursement;

public interface EmployeeDAO {
	
	public List<Reimbursement> getPendingReimbursements(String username);
	public List<Reimbursement> getAllPending();
	public List<Reimbursement> getResolvedReimbursements(String username);
	public List<Reimbursement> getAllResolved();
	public boolean createExpense(Reimbursement reimbursement);
	public boolean typeIs(String username, String password);

}
