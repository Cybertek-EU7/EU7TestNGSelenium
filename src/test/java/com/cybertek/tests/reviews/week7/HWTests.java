package com.cybertek.tests.reviews.week7;

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
}
