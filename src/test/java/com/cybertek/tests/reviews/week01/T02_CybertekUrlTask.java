package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T02_CybertekUrlTask {
    /*
    Use WebDriverFactory
    * go to http://practice.cybertekschool.com/ website
    * verify if the URL contains "cybertekschool"
    * Verify the title as well  "Practice"
     */

    public static void main(String[] args) {

        // initialize my driver object
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // I want to maximize my page, sometimes selenium can not find element without maximize
        driver.manage().window().maximize();
        // go to the page
        driver.get("http://practice.cybertekschool.com/");



        String expectedUrlText = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        System.out.println("verify if the URL contains \"cybertekschool\" : "+actualUrl.contains(expectedUrlText));

        System.out.println("Title verify : "+ driver.getTitle().equalsIgnoreCase("Practice"));

        driver.close();

    }

}
