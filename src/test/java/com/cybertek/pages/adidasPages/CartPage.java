package com.cybertek.pages.adidasPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePageForAdidas{
//    public CartPage(){
//        super();
//    }  No need to call parent constructor, because it is already called

    @FindBy(css = "button[class='btn btn-success']")
    public WebElement placeOrderButton;
    @FindBy(id = "name")
    public WebElement nameFake;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "card")
    public WebElement card;
    @FindBy(id = "month")
    public WebElement month;
    @FindBy(id = "year")
    public WebElement year;



    public void fillForm(){
        Faker faker = new Faker();


    }


}
