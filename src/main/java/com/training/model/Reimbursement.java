package com.training.model;

import java.sql.Date;
import java.util.Objects;

public class Reimbursement {
	private int reimbursementId;
	private String r_type;
	private String status;
	private long amount;
	private Date created_date;
	private Date submitted_date;
	private String username;
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}

	

	public Reimbursement(int reimbursementId, String r_type, String status, long amount, Date created_date,
			Date submitted_date, String username) {
		this.reimbursementId = reimbursementId;
		this.r_type = r_type;
		this.status = status;
		this.amount = amount;
		this.created_date = created_date;
		this.submitted_date = submitted_date;
		this.username = username;
	}



	



	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getSubmitted_date() {
		return submitted_date;
	}

	public void setSubmitted_date(Date submitted_date) {
		this.submitted_date = submitted_date;
	}
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public int hashCode() {
		return Objects.hash(amount, created_date, r_type, reimbursementId, status, submitted_date, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return amount == other.amount && Objects.equals(created_date, other.created_date)
				&& Objects.equals(r_type, other.r_type) && reimbursementId == other.reimbursementId
				&& Objects.equals(status, other.status) && Objects.equals(submitted_date, other.submitted_date)
				&& Objects.equals(username, other.username);
	}



	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", r_type=" + r_type + ", status=" + status
				+ ", amount=" + amount + ", created_date=" + created_date + ", submitted_date=" + submitted_date
				+ ", username=" + username + "]";
	}

	
	
	
}
