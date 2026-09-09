package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.CartPage;
import com.jaikisan.automation.pages.ProductPage;

public class TC11_CheckoutNavigationTest extends BaseTest {

    @Test
    public void verifyProceedToCheckout() throws InterruptedException {

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

        // Verify Proceed to Checkout button
        By checkoutButton = By.xpath(
                "//a[contains(@href,'/checkout') and contains(.,'Proceed to Checkout')]"
        );

        Assert.assertTrue(
                driver.findElements(checkoutButton).size() > 0,
                "Proceed to Checkout button should be displayed"
        );

        // Click Proceed to Checkout
        cartPage.clickProceedToCheckout();

        Thread.sleep(2000);

        // Get current URL
        String currentUrl = driver.getCurrentUrl();

        System.out.println(
                "URL after clicking Proceed to Checkout: "
                + currentUrl
        );

        // Verify user is redirected to Login page
        Assert.assertTrue(
                currentUrl.contains("/login"),
                "User should be redirected to Login page before checkout"
        );

        System.out.println(
                "TC11: Proceed to Checkout redirected to Login page successfully."
        );
    }
}