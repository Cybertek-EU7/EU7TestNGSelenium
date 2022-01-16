package com.cybertek.tests.reviews.week6;

import com.cybertek.pages.adidasPages.BasePageForAdidas;
import com.cybertek.pages.adidasPages.ProductPage;
import com.cybertek.tests.TestBaseTwo;
import org.testng.annotations.Test;

public class AdidasTaskWithPOM extends TestBaseTwo {

    int expectedPurchaseAmount = 0;
    ProductPage productPage = new ProductPage();
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


//        productPage.navigateTo("Laptops");
//        productPage.navigateTo("Sony vaio i5");
//        System.out.println("productPage.priceElement.getText() = " + productPage.priceElement.getText());
//        System.out.println("productPage.productDescription.getText() = " + productPage.productDescription.getText());
    }


}
