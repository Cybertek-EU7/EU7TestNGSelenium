package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHWTest {
    /*
    Test case
            Go to Ebay
            search Selenium
            click on search button
            print number of results
            verify title contains Selenium
     */

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();  // handles all those downloading necessary driver for your operating system

        WebDriver driver = WebDriverFactory.getDriver("chrome"); // open an empty browser
        // Go to Ebay
        driver.get("https://www.ebay.com/");

        // search Selenium

     // with ID locator  WebElement searchBox = driver.findElement(By.id("gh-ac"));// to duplicate a line CTRL+D CMND+D


   //  with name locator  WebElement searchBox = driver.findElement(By.name("_nkw"));

      // this is xpath with class name attribute
       WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));

    //     WebElement searchBox = driver.findElement(By.className("gh-tb ui-autocomplete-input"));

        //  for tagName  //input tag for search box reveals 7 items and my element is the 3rd one

        String expectedSearcItem = "Selenium";

        searchBox.sendKeys(expectedSearcItem);

       WebElement searchButton = driver.findElement(By.id("gh-btn")); // locate the element
       searchButton.click();  // apply action

   WebElement searchResultElement = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));

   String searchResultText = searchResultElement.getText();

   String [] arr = searchResultText.split(" ");

        System.out.println("Number os search results = " + arr[0]);


        driver.close();

    }

}
