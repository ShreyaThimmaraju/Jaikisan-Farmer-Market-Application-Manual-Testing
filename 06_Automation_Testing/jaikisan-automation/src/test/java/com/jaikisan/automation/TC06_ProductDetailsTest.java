package com.jaikisan.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;

public class TC06_ProductDetailsTest extends BaseTest {

    @Test
    public void verifyAlphonsoMangoesProductDetails() throws InterruptedException {

        // Click Fruits category
        driver.findElement(
                org.openqa.selenium.By.xpath("//a[contains(.,'Fruits')]")
        ).click();

        Thread.sleep(3000);

        // Click Alphonso Mangoes product
        driver.findElement(
                org.openqa.selenium.By.xpath("//a[contains(.,'Alphonso Mangoes')]")
        ).click();

        Thread.sleep(3000);

        // Create Product Page object
        ProductPage productPage = new ProductPage(driver);

        // Get product details
        String productName = productPage.getProductName();
        String productPrice = driver.findElement(
        org.openqa.selenium.By.tagName("body")
).getText();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);

        // Verify product name
        Assert.assertTrue(
                productName.contains("Alphonso Mangoes"),
                "Alphonso Mangoes product name should be displayed"
        );

        // Verify price
        Assert.assertTrue(
                productPrice.contains("250"),
                "Product price 250 should be displayed"
        );

        // Verify Add to Cart button
        Assert.assertTrue(
                driver.findElement(
                        org.openqa.selenium.By.xpath(
                                "//button[contains(.,'Add to Cart')]"
                        )
                ).isDisplayed(),
                "Add to Cart button should be displayed"
        );

        System.out.println(
                "TC06: Alphonso Mangoes product details verified successfully."
        );
    }
}