package com.project.pages;

import com.project.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class IFramePage {
    WebDriver driver;
    By iFrame = By.id("email-subscribe");

    public IFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToIframe() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(iFrame));
        Thread.sleep(3000);
        driver.switchTo().frame("email-subscribe");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("Iframe testing");
        Thread.sleep(4000);
        System.out.println("Entered iframe");
        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
    }

}

