package com.training.ers.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginDAOImplTest {
	
	LoginDAO loginDAO;
	
	String username;
	String password;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		loginDAO = new LoginDAOImpl();
		username = "john";
		password = "password";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidate() {
		assertTrue(() -> loginDAO.validate(username,password));
	}

}
