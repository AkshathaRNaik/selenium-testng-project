package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

	public static WebDriver driver;

	public static WebDriver initDriver() {
		WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//		driver = new ChromeDriver(options);
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getdriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}

	}
}
