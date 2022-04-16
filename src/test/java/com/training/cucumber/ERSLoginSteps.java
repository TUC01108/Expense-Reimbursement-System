package com.training.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.training.ers.pages.LoginPage_PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ERSLoginSteps {
	
	String browserName = "edge";
	
	WebDriver driver;
	
	LoginPage_PageFactory loginPage;
	
	@Given("new tab is open")
	public void new_tab_is_open() {
		System.out.println("#Step - tab is open");
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
	    loginPage = new LoginPage_PageFactory(driver);
	}

	@Given("user is on login page of ERS project")
	public void user_is_on_login_page_of_ers_project() {
		System.out.println("#Step - user is on login page");
		driver.get("http://localhost:8080/Winter-ERS-Project1/login.html");
		assertTrue(loginPage.checkLoginDisplayed());
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		System.out.println("#Step - user enters username and password");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("user clicks on login button of ERS project")
	public void user_clicks_on_login_button_of_ers_project() {
		System.out.println("#Step - user clicks on login button");
		loginPage.clickLogin();
	}

	@Then("user is navigated to home page of ERS project")
	public void user_is_navigated_to_home_page_of_ers_project() {
		assertTrue(loginPage.checkLogoutDisplayed());
	    System.out.println("#Step - user is navigated to the home page");
	    
	    driver.close();
	    driver.quit();
	}
	
}