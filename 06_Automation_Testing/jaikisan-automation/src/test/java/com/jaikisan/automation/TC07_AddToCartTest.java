package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;

public class TC07_AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Navigate to Fruits
        By fruitsLink = By.xpath(
                "//a[contains(.,'Fruits')]"
        );

        wait.until(driver -> {
            try {
                driver.findElement(fruitsLink).click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });

        // Wait for Fruits category page
        wait.until(
                ExpectedConditions.urlContains("/categories/fruits")
        );

        // Open Alphonso Mangoes
        By alphonsoMangoes = By.xpath(
                "//a[contains(.,'Alphonso Mangoes')]"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(alphonsoMangoes)
        ).click();

        // Wait for product page
        wait.until(
                ExpectedConditions.urlContains(
                        "/products/alphonso-mangoes-fresh"
                )
        );

        // Create Product Page object
        ProductPage productPage = new ProductPage(driver);

        // Add product to cart
        productPage.clickAddToCart();

        // Wait until Add to Cart changes to Added to Cart
        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.tagName("body"),
                        "Added to Cart"
                )
        );

        // Verify product is still displayed
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