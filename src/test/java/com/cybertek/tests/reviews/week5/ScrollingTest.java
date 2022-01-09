package com.cybertek.tests.reviews.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {
    /*
    http://practice.cybertekschool.com/

    - P.I.Q.: How many ways do you know to scroll using Selenium?
    1. action.moveToElement().perform()
    2. PageUp, PageDown keys for scrolling

        action.sendKeys(Keys.PAGE_UP, PAGE_DOWN)

    3. jse.executeScript("window.scrollBy(0,250)");
    4. jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);
     */
// What is TestNG ? Unit testing tool, like JUNIT
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void tearDown(){
       driver.close();
    }

    @Test
    public void moveToElementTest() throws InterruptedException { // Declared the exception
        // Scroll down to Powered by Cybertek School
        Actions actions = new Actions(driver);
        // locate the element
        WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
        // scrolling to that elelement
        Thread.sleep(5000);      // checked exception

        actions.moveToElement(cybertekschoolLink).perform();

        Thread.sleep(3000);

        // advanced Keyboard actions
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);

    }


}
