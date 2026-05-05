package com.project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TimeUtil {

    public static String getTimestamp() {
        Date date = new Date();
        System.out.println(date);
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);
    }

    public static WebElement waitElementVisibility(WebDriver driver, int duration, By address) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(address));
    }

    public static boolean waitForText(WebDriver driver, int duration, By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static void waitForInvisibility(WebDriver driver, int duration, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


}
