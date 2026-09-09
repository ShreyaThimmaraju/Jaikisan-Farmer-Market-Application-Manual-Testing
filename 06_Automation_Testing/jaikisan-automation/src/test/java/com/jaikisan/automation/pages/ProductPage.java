package com.jaikisan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    // Product name
    private By productName = By.xpath(
            "//h1[contains(.,'Alphonso Mangoes')]"
    );

    // Price
    private By productPrice = By.xpath(
            "//*[contains(text(),'₹250') or contains(text(),'250')][1]"
    );

    // Add to Cart button
    private By addToCartButton = By.xpath(
            "//button[contains(.,'Add to Cart')]"
    );

    
    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Get product name
    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    // Get product price
    public String getProductPrice() {
        return driver.findElement(
                By.xpath("//*[contains(text(),'250') and not(contains(text(),'₹'))][1]")
        ).getText();
    }

    // Click Add to Cart
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}