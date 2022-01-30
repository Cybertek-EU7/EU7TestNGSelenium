package com.cybertek.tests.reviews.week7;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HWTests extends TestBaseForHW{

    @Test
    public void verifyOptionsTest(){
            extentLogger = report.createTest("Verify Options Link");
            extentLogger.info("Preconditions Loaded");
            extentLogger.info("Verify that Options Link is Displayed");
            Assert.assertTrue(page.optionsLink.isDisplayed(),"Link is NOT Displayed");
            extentLogger.pass("Options is Displayed");
    }

    @Test
    public void verifyPageNumber(){
            extentLogger = report.createTest("Verify Page Number");
            int pageNumber = Integer.parseInt(page.pageNumber.getAttribute("value"));
            extentLogger.info("verify page number");
            Assert.assertEquals(pageNumber,2,"Page Number is NOT equal to 1");
            extentLogger.pass("page number verified");
    }

    @Test
    public void verifyViewPerPageTest(){
        extentLogger = report.createTest("Verify View Per Page Test");
        wait.until(ExpectedConditions.visibilityOf(page.viewPerPage));
        System.out.println("page.viewPerPage.getText() = " + page.viewPerPage.getText());
        int viewPerPage = Integer.parseInt(page.viewPerPage.getText().trim());
        extentLogger.info("Verify View Per Page is 25");
        Assert.assertEquals(viewPerPage,25,"View Per Page is NOT equal to 25 ");
        extentLogger.pass("Test PASSED");
    }
}
