package com.cybertek.tests.reviews.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_YahooPractice {
    /*
    open the webpage
    go to https://www.yahoo.com/
    verify the title
      expectedTitle= "Yahoo"
      actualTitle = webPage
     */

    public static void main(String[] args) {

        // setUp browser type
        WebDriverManager.chromedriver().setup();

        // how can I open a new page, this statement opens an empty page
        WebDriver driver = new ChromeDriver();

        // go to the page
        driver.get("https://www.yahoo.com/");

        String expectedTitle = "Yahoo";

        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.close();
    }


}
