package com.project.pages;

import com.project.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class SeleniumRevisePage {

    WebDriver driver = DriverManager.getdriver();
    private static WebElement dropdown;
    private By selectDropdown = By.id("oldSelectMenu");
    private By multiDropdownButton = By.id("react-select-4-input");
    private By multiDropdownOptions = By.xpath("//div[@aria-multiselectable='true']//div");

    public void selectMenu() {
        dropdown = driver.findElement(selectDropdown);
        if (dropdown.isDisplayed()) {
            dropdown.click();
        }
    }

    public void selectOptions() {
        Select select = new Select(dropdown);
        List<WebElement> selectoptions = select.getOptions();
        for (WebElement ele : selectoptions) {
            System.out.println(ele.getText());
        }
        select.selectByValue("red");
    }

    public void multiSelectDropdown() throws InterruptedException {
        WebElement element = driver.findElement(multiDropdownButton);
        element.click();
        System.out.println("dropdown click successful");
        List<WebElement> options = driver.findElements(multiDropdownOptions);
        for (WebElement opt : options) {
            if (opt.getText().equals("Green") || opt.getText().equals("Blue")) {
                opt.click();
                System.out.println(opt.getText());
            }
           Iterator itr = options.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
            itr.remove();
        }
        Thread.sleep(10000);
    }

    public void mouseActions() throws IOException {
        WebElement ele = driver.findElement(multiDropdownButton);
        Actions actions = new Actions(driver);
        actions.contextClick(ele).perform();
        actions.dragAndDrop(ele, dropdown);
        actions.moveToElement(ele).click().build().perform();
        actions.clickAndHold().release().build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).sendKeys("abgb").keyUp(Keys.ARROW_DOWN).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("arguments[0].click(); arguments[1].scrollIntoView(true); ", element1,element2);
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,-500)");
        js.executeScript("window.scrollTo(0,0)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, 0)");

        js.executeScript("arguments[0].click();", ele);
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        js.executeScript("window.scrollBy(0,400)");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File("sc.png");
        FileUtils.copyFile(src, des);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("img.png"));
        String parentwindow = driver.getWindowHandle();
        Set<String> childwindows = driver.getWindowHandles();

        for (String windowhandle : childwindows) {
            if (!windowhandle.equals(parentwindow)) {
                driver.switchTo().window(windowhandle);
                System.out.println(driver.getCurrentUrl() + driver.getTitle());
            } else {
                driver.switchTo().window(parentwindow);
            }
        }
        driver.quit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Applies globally to all elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("wait locator")));
        element.click();

        Wait<WebDriver> fluentwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement eleme = wait.until(
                driver -> driver.findElement(By.id("login"))
        );
        element.click();

      List<WebElement> rows =  driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(rows.size());

        for( WebElement row : rows)
        {
          List<WebElement> columns = row.findElements(By.tagName("td"));
          for(WebElement column : columns){
              System.out.print(column.getText() +" ");
          }
            System.out.println();

        }

    }
}
