package com.training.ers.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory {
	WebDriver driver;
	@FindBy(id ="floatingInput")
	WebElement txt_username;
	
	@FindBy(id ="floatingPassword")
	WebElement txt_password;
	
	@FindBy(id ="btnSubmit")
	WebElement btn_login;
	
	@FindBy(xpath ="/html/body/div/a")
	WebElement btn_logout;
	
	
	public LoginPage_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	public void clickLogin() {
		btn_login.click();
	}
	public boolean checkLogoutDisplayed() {
		return btn_logout.isDisplayed();
	}
	public boolean checkLoginDisplayed() {
		return btn_login.isDisplayed();
	}
}
