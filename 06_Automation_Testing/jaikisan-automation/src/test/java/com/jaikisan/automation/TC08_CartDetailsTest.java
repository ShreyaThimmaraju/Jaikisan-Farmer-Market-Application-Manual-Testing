package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;
import com.jaikisan.automation.pages.CartPage;

public class TC08_CartDetailsTest extends BaseTest {

    @Test
    public void verifyCartDetails() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Navigate to Fruits
        By fruitsLink = By.xpath("//a[contains(.,'Fruits')]");

        wait.until(driver -> {
            try {
                driver.findElement(fruitsLink).click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });

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

        wait.until(
                ExpectedConditions.urlContains(
                        "/products/alphonso-mangoes-fresh"
                )
        );

        // Add product to cart
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();

        wait.until(
        ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("body"),
                "Added to Cart"
        )
);

        // Open Cart
        By cartLink = By.xpath(
                "//a[contains(@href,'/cart')]"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(cartLink)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/cart")
        );

        System.out.println(
                "CURRENT CART URL: " + driver.getCurrentUrl()
        );

        String cartPageText = driver
                .findElement(By.tagName("body"))
                .getText();

        System.out.println("CART PAGE CONTENT:");
        System.out.println(cartPageText);

        // Verify Shopping Cart page
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isShoppingCartDisplayed(),
                "Shopping Cart page should be displayed"
        );

        // Check whether cart is empty
        boolean cartIsEmpty = cartPageText.contains(
                "Your cart is empty"
        );

        // Check whether Alphonso Mangoes is actually displayed
        boolean productIsDisplayed = cartPageText.contains(
                "Alphonso Mangoes"
        );

        System.out.println(
                "Cart Empty Message Displayed: " + cartIsEmpty
        );

        System.out.println(
                "Alphonso Mangoes Displayed: " + productIsDisplayed
        );

        // Product must be present in cart
        Assert.assertFalse(
                cartIsEmpty,
                "BUG_006: Cart is empty after adding Alphonso Mangoes."
        );

        Assert.assertTrue(
                productIsDisplayed,
                "BUG_006: Alphonso Mangoes should be displayed in the cart."
        );

        System.out.println(
                "TC08: Cart details verified successfully."
        );
    }
}