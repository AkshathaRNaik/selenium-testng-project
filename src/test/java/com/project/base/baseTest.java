package com.project.base;

import java.time.Duration;

import com.project.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.project.driver.DriverManager;

public class baseTest {

   public WebDriver driver = DriverManager.getdriver();

    @BeforeMethod
    public void setup() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.get(ConfigReader.getAmazonUrl());
        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
