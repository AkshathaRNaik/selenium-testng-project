package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

//	public static WebDriver driver;
//
//	public static WebDriver initDriver() {
//		WebDriverManager.chromedriver().setup();
    /// /        ChromeOptions options = new ChromeOptions();
    /// /        options.addArguments("--headless");
    /// /		driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		return driver;
//	}
//
//	public static WebDriver getDriver() {
//		if (driver == null) {
//			initDriver();
//		}
//		return driver;
//	}
//
//	public static void quitDriver() {
//		if (driver != null) {
//			driver.quit();
//		}
//
//	}

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//    public static WebDriver driver;

    public static void initDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("no supported browser");
        }
        driver.manage().window().maximize();
        tlDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
