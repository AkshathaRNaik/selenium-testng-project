package com.project.pages;

import com.project.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AmazonDashboardPage {
    WebDriver driver = DriverManager.getDriver();

    private static By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    private static By searchText = By.xpath("//input[@id='twotabsearchtextbox']//following::div[text()='samsung']");
    private static By getLink = By.xpath("//div[text()='Make Money with Us']//following-sibling::ul//li//a");

    public void getSearchData() {
        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys("samsung");
        List<WebElement> webElements = driver.findElements(searchText);
        System.out.println(webElements.get(0).getText());

        for (WebElement element : webElements) {
            System.out.println(element.getText());
        }
    }

    public void getLinks() {
        List<WebElement> links = driver.findElements(getLink);
        List actualLinks = new ArrayList();
        for (WebElement element : links) {
            actualLinks.add(element.getAttribute("href"));
        }
        int count=1;
        System.out.println("Links : ");
        for (Object eachLink : actualLinks) {
            System.out.println( count + " : " + eachLink);
            count++;
        }

        List expLinks = new ArrayList();
        expLinks.addAll(actualLinks);
        actualLinks.remove(3);
        if (actualLinks.containsAll(expLinks)) {
            System.out.println("Both lists are equal");
        }
        else{
            System.out.println("Lists are not equal");
        }

    }
}
