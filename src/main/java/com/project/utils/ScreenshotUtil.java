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


    public String takeScreenshot(String testName) throws IOException {
        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            System.out.println("Driver is null, skipping screenshot");
            return null;
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshots/" + testName + "_" + TimeUtil.getTimestamp() + ".png";
        File dest = new File(path);
        FileUtils.copyFile(src,dest);
//        Files.copy(src.toPath(), dest.toPath());
        return path;
    }
}