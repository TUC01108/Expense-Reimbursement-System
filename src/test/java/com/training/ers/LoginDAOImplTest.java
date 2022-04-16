package com.training.ers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.ers.dao.LoginDAO;
import com.training.ers.dao.LoginDAOImpl;

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
		username = "test";
		password = "root123";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidate() {
		assertTrue(() -> loginDAO.validate(username,password));
	}

}
