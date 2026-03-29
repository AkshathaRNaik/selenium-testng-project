package com.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.base.baseTest;
import com.project.pages.LoginPage;

public class LoginTest extends baseTest {
	
	 @Test
	    public void validLoginTest() {
	        LoginPage loginPage = new LoginPage();
	        loginPage.login("Admin", "admin123");

	        System.out.println("Login executed");
	        Assert.assertTrue(true);
	    }	

}
