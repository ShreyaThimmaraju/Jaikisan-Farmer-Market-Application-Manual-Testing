package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;
import com.jaikisan.automation.pages.CartPage;

public class TC09_IncreaseCartQuantityTest extends BaseTest {

    @Test
    public void verifyIncreaseCartQuantity() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Click Fruits category
        By fruitsLink = By.xpath("//a[contains(.,'Fruits')]");

        wait.until(
                ExpectedConditions.elementToBeClickable(fruitsLink)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/categories/fruits")
        );

        // Click Alphonso Mangoes
        By alphonsoMangoes = By.xpath(
                "//a[contains(.,'Alphonso Mangoes')]"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(alphonsoMangoes)
        ).click();

        wait.until(
                ExpectedConditions.urlContains(
                        "/products/alphonso-mangoes-fresh"
                )
        );

        // Create Product Page object
        ProductPage productPage = new ProductPage(driver);

        // Add product to cart
        productPage.clickAddToCart();

        Thread.sleep(2000);

        // Open Cart
        By cartLink = By.xpath("//a[contains(@href,'/cart')]");

        wait.until(
                ExpectedConditions.elementToBeClickable(cartLink)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );

        // Create Cart Page object
        CartPage cartPage = new CartPage(driver);

        // Get initial quantity
        String initialQuantity = cartPage.getQuantity();

        System.out.println(
                "Initial Quantity: " + initialQuantity
        );

        // Click + button
        cartPage.clickPlusButton();

        Thread.sleep(2000);

        // Get updated quantity
        String updatedQuantity = cartPage.getQuantity();

        System.out.println(
                "Quantity after clicking +: " + updatedQuantity
        );

        // Convert quantity to integers
        int initial = Integer.parseInt(initialQuantity);
        int updated = Integer.parseInt(updatedQuantity);

        // Verify quantity increased by 1
        Assert.assertEquals(
                updated,
                initial + 1,
                "Quantity should increase by 1 after clicking +"
        );

        System.out.println(
                "TC09: Cart quantity increased successfully."
        );
    }
}