package com.cybertek.tests.reviews.week7;

import com.cybertek.utilities.Driver;
import org.apache.poi.hssf.record.chart.DatRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderExample {
    /*
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “301”.
    Step 4. Verify that following message is displayed:
    “This page returned a 301 status code”
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @DataProvider
    public Object [][] getData(){
        String [][] data = new String[4][2];
        // test case number 9
        data[0][0] = "200";
        data[0][1] = "This page returned a 200 status code";
        // test case number 10
        data[1][0] = "301";
        data[1][1] = "This page returned a 301 status code";
    // test case number 11
        data[2][0] = "404";
        data[2][1] = "This page returned a 404 status code";
        // test case number 12
        data[3][0] = "500";
        data[3][1] = "This page returned a 500 status code";

        /*
        String[][] data = {
                {"200","This page returned a 200 status code."},
                {"301","This page returned a 301 status code."},
                {"404","This page returned a 404 status code."},
                {"500","This page returned a 500 status code."}
        };
         */
        return data;
    }

    @Test(dataProvider = "getData")
    public void StatusCodesTests(String code, String expectedMessage){
       // String code = "301";
       //  String expectedMessage = "This page returned a 301 status code";
        driver.findElement(By.linkText(code)).click();  // clicks on 200 status code

        String actualMessage = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

}
