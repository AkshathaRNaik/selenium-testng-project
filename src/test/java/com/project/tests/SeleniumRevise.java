package com.project.tests;

import com.project.base.baseTest;
import com.project.pages.SeleniumRevisePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SeleniumRevise extends baseTest {
   @Test
    public void selectClass() throws InterruptedException {
       System.out.println("page title : " + driver.getTitle());
       SeleniumRevisePage revise = new SeleniumRevisePage();
//       revise.selectMenu();
//       revise.selectOptions();
       revise.multiSelectDropdown();

    }
@Test
@Parameters("browser")
    public void asserttest(){
    Assert.assertEquals("akshu" , "akshu");
    SoftAssert soft = new SoftAssert();
    soft.assertTrue(driver.findElement(By.xpath("true")).isDisplayed());
    soft.assertEquals("akshau" , "akshu");
    soft.assertAll();
}
}
