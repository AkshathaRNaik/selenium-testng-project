package com.project.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.project.driver.DriverManager;

public class baseTest {

	WebDriver driver = DriverManager.getdriver();

	@BeforeMethod
	public void setup() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
