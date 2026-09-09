package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.CartPage;
import com.jaikisan.automation.pages.ProductPage;

public class TC10_DeleteProductTest extends BaseTest {

    @Test
    public void verifyDeleteProductFromCart() throws InterruptedException {

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

        // Verify product is present
        Assert.assertTrue(
                cartPage.isProductDisplayed(),
                "Alphonso Mangoes should be present in cart"
        );

        // Click Delete button
        cartPage.clickDeleteButton();

        Thread.sleep(2000);

        // Verify product is removed
        Assert.assertFalse(
                cartPage.isProductDisplayed(),
                "Alphonso Mangoes should be removed from cart after clicking Delete"
        );

        System.out.println(
                "TC10: Product deleted from cart successfully."
        );
    }
}