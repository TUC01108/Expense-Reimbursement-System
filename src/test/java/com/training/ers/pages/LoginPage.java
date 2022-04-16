package com.training.ers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By txt_username = By.id("floatingInput");
	By txt_password = By.id("floatingPassword");
	By btn_login = By.id("btnSubmit");
	By btn_logout = By.xpath("/html/body/div/a");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	public boolean checkLogoutDisplayed() {
		return driver.findElement(btn_logout).isDisplayed();
	}
	public boolean checkLoginDisplayed() {
		return driver.findElement(btn_login).isDisplayed();
	}
}
