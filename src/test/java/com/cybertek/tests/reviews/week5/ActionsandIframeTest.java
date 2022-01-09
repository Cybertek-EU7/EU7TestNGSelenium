package com.cybertek.tests.reviews.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsandIframeTest {
//1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//2. Switch to iframe.
//3. Double click on the text “Double-click me to change my text color.”
//4. Assert: Text’s “style” attribute value contains “red”.

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test() throws InterruptedException {

        Thread.sleep(1000);
        //2. Switch to iframe.
        // We are switching to iframe using id attribute value and switchTo method.
        driver.switchTo().frame("iframeResult");

        //Locating the text to double click
        WebElement textToDoubleClick = driver.findElement(By.id("demo"));

        //3. Double click on the text “Double-click me to change my text color.”
        Actions actions = new Actions(driver);

        //use the 'actions' object to double click to already located web element
        Thread.sleep(2000);
        actions.doubleClick(textToDoubleClick).perform();
        //actions.perform();
        Thread.sleep(2000);
        //4. Assert: Text’s “style” attribute value contains “red”.
        String expectedInStyle = "red";
        String actual = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actual.contains(expectedInStyle));


    }
}



