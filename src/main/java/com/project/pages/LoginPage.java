package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.driver.DriverManager;

public class LoginPage {
	WebDriver driver = DriverManager.getdriver();

	 private By username = By.name("username");
	    private By password = By.name("password");
	    private By loginBtn = By.xpath("//button[@type='submit']");

	    public void login(String user, String pass) {
	    	driver.findElement(username).sendKeys(user);
	    	driver.findElement(password).sendKeys(pass);
	    	driver.findElement(loginBtn).click();
	    
	
	    }
}
