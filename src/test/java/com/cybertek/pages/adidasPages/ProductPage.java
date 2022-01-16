package com.cybertek.pages.adidasPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePageForAdidas{

    @FindBy(tagName = "h2")
   public WebElement productName;

    @FindBy(tagName = "h3")
    public WebElement priceElement;

    @FindBy(xpath = "(//p)[4]")
    public WebElement productDescription;

}
