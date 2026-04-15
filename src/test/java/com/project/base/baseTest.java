package com.project.base;

import java.time.Duration;

import com.project.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.project.driver.DriverManager;
import org.testng.annotations.Parameters;

public class baseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browserName) {
        DriverManager.initDriver(browserName);
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfigReader.getAmazonUrl());
//        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {
       DriverManager.quitDriver();

    }

}
