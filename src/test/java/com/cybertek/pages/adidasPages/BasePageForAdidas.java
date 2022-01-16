package com.cybertek.pages.adidasPages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageForAdidas {

    public BasePageForAdidas(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateTo(String str){
        Driver.get().findElement(By.partialLinkText(str)).click();
    }

    public int productAdder(String category, String product){
        navigateTo(category);
        navigateTo(product);
        // I want to get my expected price for that product
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        WebElement priceElement = Driver.get().findElement(By.tagName("h3"));
        String priceWholeText = priceElement.getText();
        String[] arr = priceWholeText.split(" ");
        int listPrice = Integer.parseInt(arr[0].substring(1));

        navigateTo("Add to cart");
        // handle pop up
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
        navigateTo("Home");
        return listPrice;
    }

    public int productRemover(String product)  {
        // locator //tr[contains(.,'Sony vaio i5')]/td[4]/a
        // locator for price text : //tr[contains(.,'Sony vaio i5')]/td[3]
        navigateTo("Cart");
        WebElement priceElement = Driver.get().findElement(By.xpath("//tr[contains(.,'"+product+"')]/td[3]"));
        int price = Integer.parseInt(priceElement.getText());
        WebElement deleteButton = Driver.get().findElement(By.xpath("//tr[contains(.,'"+product+"')]/td[4]/a"));
        deleteButton.click();
        BrowserUtils.waitFor(3);

        return price;
    }


}
