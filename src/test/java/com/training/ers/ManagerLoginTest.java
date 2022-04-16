package com.training.ers;

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

class ManagerLoginTest {
	
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
		driver.get("http://localhost:8080/Winter-ERS-Project1/index.jsp");
		driver.manage().window().maximize();
		//locators
		driver.findElement(By.xpath("/html/body/div/main/p[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"floatingInput\"]")).sendKeys("manager4");
		driver.findElement(By.xpath("//*[@id=\"floatingPassword\"]")).sendKeys("rootroot");
		//driver.findElement(By.xpath("/html/body/div/main/form/div[3]/label[2]")).click();
		driver.findElement(By.xpath("/html/body/div/main/form/button")).click();
		
		assertTrue(driver.findElement(By.id("viewallusers")).isDisplayed());
	}
	
	
	@AfterEach
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
