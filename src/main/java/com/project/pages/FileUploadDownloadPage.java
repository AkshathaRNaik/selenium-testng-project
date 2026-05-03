package com.project.pages;

import com.project.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class FileUploadDownloadPage {
    WebDriver driver;

    public FileUploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    By chooseFile = By.id("uploadFile");
    By downloadFile = By.id("downloadButton");

    public void uploadFileSendkeys() throws InterruptedException {
        driver.findElement(chooseFile).sendKeys(ConfigReader.getValue("UploadFilePath"));
        Thread.sleep(5000);
        driver.findElement(downloadFile).click();
        Thread.sleep(3000);
    }

    public void uploadFileRobot() throws AWTException, InterruptedException {
        WebElement uploadBtn = driver.findElement(chooseFile);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(uploadBtn));
        System.out.println(uploadBtn.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadBtn);
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.setAutoDelay(300);
        StringSelection filePath = new StringSelection(ConfigReader.getValue("UploadFilePath"));   //This wraps the string so Java can treat it like something you can copy
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);      //Takes that file path and Puts it into your system clipboard (like Ctrl+C)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }
}
