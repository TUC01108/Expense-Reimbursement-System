package com.training.model;

import java.util.Objects;

public class Manager {
	private int managerId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int login_id;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(int managerId, String username, String password, String firstname, String lastname, String email,
			int login_id) {
		this.managerId = managerId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.login_id = login_id;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, lastname, login_id, managerId, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && login_id == other.login_id
				&& managerId == other.managerId && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", login_id=" + login_id + "]";
	}
	
	

}
