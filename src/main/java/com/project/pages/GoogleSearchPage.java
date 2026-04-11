package com.project.pages;

import com.project.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage {
    public WebDriver driver = DriverManager.getdriver();
    private static By searchBox = By.xpath("//textarea[@title='Search']");
    private static By searchText = By.xpath("//div[@role='presentation']//child::span[contains(text(),'prestige') or contains(text(),'Prestige')]");

    public void googleSearchFunctionality() {
        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys("prestige");
        List<WebElement> elements = driver.findElements(searchText);
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }
}
