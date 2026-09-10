package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;

public class TC06_ProductDetailsTest extends BaseTest {

    @Test
    public void verifyAlphonsoMangoesProductDetails() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Click Fruits category
        By fruitsLink = By.xpath(
                "//a[contains(.,'Fruits')]"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(fruitsLink)
        ).click();

        // Wait for Fruits category page
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

        // Wait for product page
        wait.until(
                ExpectedConditions.urlContains(
                        "/products/alphonso-mangoes-fresh"
                )
        );

        // Create Product Page object
        ProductPage productPage = new ProductPage(driver);

        // Get product name
        String productName = productPage.getProductName();

        // Get complete page text for price verification
        String pageText = driver.findElement(
                By.tagName("body")
        ).getText();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Page Content:");
        System.out.println(pageText);

        // Verify product name
        Assert.assertTrue(
                productName.contains("Alphonso Mangoes"),
                "Alphonso Mangoes product name should be displayed"
        );

        // Verify price
        Assert.assertTrue(
                pageText.contains("250"),
                "Product price 250 should be displayed"
        );

        // Verify Add to Cart button
        By addToCartButton = By.xpath(
                "//button[contains(.,'Add to Cart')]"
        );

        Assert.assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                addToCartButton
                        )
                ).isDisplayed(),
                "Add to Cart button should be displayed"
        );

        System.out.println(
                "TC06: Alphonso Mangoes product details verified successfully."
        );
    }
}