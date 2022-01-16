package com.cybertek.pages.adidasPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePageForAdidas{
//    public CartPage(){
//        super();
//    }  No need to call parent constructor, because it is already called

    @FindBy(css = "button[class='btn btn-success']")
    public WebElement placeOrderButton;

}
