package com.project.utils;

import com.project.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    WebDriver driver = DriverManager.getDriver();
    public void takeScreenshot(String testName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/Screenshots/" + testName +"_" +TimeUtil.getTimestamp()+ ".png");
        Files.copy(src.toPath(),dest.toPath());
    }
}