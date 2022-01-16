package com.cybertek.tests.reviews.week6;

import com.cybertek.pages.adidasPages.BasePageForAdidas;
import com.cybertek.pages.adidasPages.CartPage;
import com.cybertek.pages.adidasPages.ProductPage;
import com.cybertek.tests.TestBaseTwo;
import org.testng.annotations.Test;

public class AdidasTaskWithPOM extends TestBaseTwo {

    int expectedPurchaseAmount = 0;
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    public void PurchaseTest(){



        // Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        expectedPurchaseAmount += productPage.productAdder("Laptop","Sony vaio i5");
        // Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        expectedPurchaseAmount += productPage.productAdder("Laptop","Dell i7 8gb");

        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

        expectedPurchaseAmount -= productPage.productRemover("Sony vaio i5");

        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

        productPage.navigateTo("Cart");

        cartPage.placeOrderButton.click();

        // need to fill up the form, I want to create a method that fills up the form
        cartPage.fillForm();

        /*
 • Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok"
         */

//        productPage.navigateTo("Laptops");
//        productPage.navigateTo("Sony vaio i5");
//        System.out.println("productPage.priceElement.getText() = " + productPage.priceElement.getText());
//        System.out.println("productPage.productDescription.getText() = " + productPage.productDescription.getText());
    }


}
