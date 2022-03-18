package com.training.ers.dao;

import java.util.List;

import com.training.model.Reimbursement;
import com.training.model.User;

public interface EmployeeDAO {
	
	public List<Reimbursement> getPendingReimbursements(String username);
	public List<Reimbursement> getResolvedReimbursements(String username);
	public boolean createExpense(Reimbursement reimbursement);

}
