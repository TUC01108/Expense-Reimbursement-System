package com.training.ers.dao;

public interface ManagerDAO {
	
	public boolean approveApply(int reimbursementId);

	public boolean rejectApply(int reimbursementId);

}
