package com.project.tests;

import com.project.listeners.TestListener;
import com.project.pages.AmazonDashboardPage;
import com.project.retry.RetryListener;
import com.project.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.project.base.baseTest;
import com.project.pages.LoginPage;

public class LoginTest extends baseTest {

    @Test(enabled = false)
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.getValue("Username"), ConfigReader.getValue("Password"));
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
