package com.jaikisan.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.ProductPage;
import com.jaikisan.automation.pages.CartPage;

public class TC08_CartDetailsTest extends BaseTest {

    @Test
    public void verifyCartDetails() throws InterruptedException {

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

        // Navigate to Shopping Cart using cart icon
        driver.findElement(
                By.xpath("//*[contains(text(),'1')]/ancestor::*[self::a or self::button][1]")
        ).click();

        Thread.sleep(3000);

        // Create Cart Page object
        CartPage cartPage = new CartPage(driver);

        // Verify Shopping Cart
        Assert.assertTrue(
                cartPage.isShoppingCartDisplayed(),
                "Shopping Cart page should be displayed"
        );

        // Verify product
        Assert.assertTrue(
                cartPage.isProductDisplayed(),
                "Alphonso Mangoes should be displayed in cart"
        );

        System.out.println(
                "TC08: Cart details verified successfully."
        );
    }
}