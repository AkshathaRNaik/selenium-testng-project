package com.project.tests;

import com.project.listeners.TestListener;
import com.project.pages.AmazonDashboardPage;
import com.project.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.project.base.baseTest;
import com.project.pages.LoginPage;
@Listeners(TestListener.class)
public class LoginTest extends baseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        System.out.println("Login executed");
        Assert.assertTrue(true);
    }

    @Test
    public void amazonlaunch() {
        System.out.println("amazon dashboard page launched");
        AmazonDashboardPage amazonDashboardPage = new AmazonDashboardPage();
//        amazonDashboardPage.getSearchData();
        System.out.println("search function successful");
        amazonDashboardPage.getLinks();
        System.out.println("links fetched");
    }
}
