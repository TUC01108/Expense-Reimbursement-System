package com.training.model;

import java.util.Objects;

public class User {
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int login_id;
	private String accounttype;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	


	public User(int userId, String username, String password, String firstname, String lastname, String email) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}




	public User(int userId, String username, String password, String firstname, String lastname, String email,
			int login_id, String accounttype) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.login_id = login_id;
		this.accounttype = accounttype;
	}



	public User(int userId, String username, String password, String firstname, String lastname, String email,
			int login_id) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.login_id = login_id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getLogin_id() {
		return login_id;
	}



	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	
	



	public String getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}


	@Override
	public int hashCode() {
		return Objects.hash(accounttype, email, firstname, lastname, login_id, password, userId, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accounttype, other.accounttype) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& login_id == other.login_id && Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", login_id=" + login_id
				+ ", accounttype=" + accounttype + "]";
	}


	

	

	
	
	
}
