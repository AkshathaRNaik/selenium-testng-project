package com.project.tests;

import com.project.base.baseTest;
import com.project.driver.DriverManager;
import com.project.pages.IFramePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class IFrameTest extends baseTest {

    @Test
    public void iFrameValidation() throws InterruptedException {
        System.out.println("IFrame testing started");
        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.switchToIframe();
    }
}
