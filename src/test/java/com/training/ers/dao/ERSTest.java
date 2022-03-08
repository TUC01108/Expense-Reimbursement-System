package com.training.ers.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class ERSTest {
	
	String browserName ="edge";
	WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		if(browserName.equals("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		 }
		 else if(browserName.equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
	}
	
	@Test
	@DisplayName("Testing login functionality of ERS")
	public void testERSLoginFunctionality(){
		driver.get("http://localhost:8080/Winter-ERS-Project1/login.html");
		driver.manage().window().maximize();
		//locators
		
		driver.findElement(By.id("username")).sendKeys("thomas");
		driver.findElement(By.id("password")).sendKeys("rootroot");
		driver.findElement(By.id("btnSubmit")).click();
		
		assertTrue(driver.findElement(By.id("searchUsers")).isDisplayed());
	}
	
	
	@AfterEach
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
