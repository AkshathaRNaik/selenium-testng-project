package com.project.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

    public static void initDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = chromeOptions();
                driver = new ChromeDriver(options);
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
//        driver.manage().window().maximize();
        tlDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();

        // Preferences
        prefs.put("profile.default_content_setting_values.notifications", 2);    //Disable Notifications
        prefs.put("profile.default_content_setting_values.popups", 2);          //Disable Popups
        prefs.put("profile.managed_default_content_settings.images", 2);        //Disable Images
        prefs.put("profile.default_content_setting_values.geolocation", 2);     //Disable Geolocation
        prefs.put("profile.default_content_setting_values.media_stream", 2);    //Disable Media (Camera/Mic)
        prefs.put("download.prompt_for_download", false);       //Disables “Save As” / “Do you want to download?” popup completely
        prefs.put("download.default_directory", System.getProperty("user.dir")+"/Downloads"); // “Save all downloaded files in this folder”
        prefs.put("safebrowsing.enabled", true);        //Controls Chrome’s security mechanism for downloads , Blocks suspicious/malicious files , Prevents unsafe downloads
        options.setExperimentalOption("prefs", prefs);

        // Arguments
        options.addArguments("--start-maximized");              //Start Maximized
//        options.addArguments("--headless=new");                 //Headless Mode
        options.addArguments("--disable-notifications");        //Disable Notifications (Backup)
        options.addArguments("--disable-infobars");             //Disable Infobars
        options.addArguments("--disable-extensions");           //Disable Extensions
        options.addArguments("--incognito");                    //Incognito Mode
        options.addArguments("--ignore-certificate-errors");     //Ignore Certificate Errors

        //Page load Strategy
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);       //Waits until: Entire page loads , HTML + CSS + JS + images
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);      //Waits Until: DOM is loaded , But does NOT wait for images, CSS, ads
//        options.setPageLoadStrategy(PageLoadStrategy.NONE);      //Does NOT wait at all , Immediately continues execution
       return options;
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
