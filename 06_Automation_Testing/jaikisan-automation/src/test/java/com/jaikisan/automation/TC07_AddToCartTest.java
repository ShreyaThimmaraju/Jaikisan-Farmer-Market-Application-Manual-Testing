package com.jaikisan.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;
import com.jaikisan.automation.pages.CartPage;

public class TC07_AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() throws InterruptedException {

        // Navigate to Fruits
        driver.findElement(
                By.xpath("//a[contains(.,'Fruits')]")
        ).click();

        Thread.sleep(3000);

        // Open Alphonso Mangoes
        driver.findElement(
                By.xpath("//a[contains(.,'Alphonso Mangoes')]")
        ).click();

        Thread.sleep(3000);

        // Create Product Page object
        ProductPage productPage = new ProductPage(driver);

        // Add product to cart
        productPage.clickAddToCart();

        Thread.sleep(2000);

        // Create Cart Page object
       String pageText = driver.findElement(
        By.tagName("body")
).getText();

System.out.println("PAGE AFTER ADD TO CART:");
System.out.println(pageText);

Assert.assertTrue(
        pageText.contains("Alphonso Mangoes"),
        "Alphonso Mangoes should be displayed after adding to cart"
);

        System.out.println(
                "TC07: Alphonso Mangoes added to cart successfully."
        );
    }
}