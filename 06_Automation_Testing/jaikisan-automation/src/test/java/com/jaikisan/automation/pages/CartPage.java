package com.jaikisan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // Shopping Cart heading
    private By shoppingCart = By.xpath(
            "//*[contains(text(),'Shopping Cart')]"
    );

    // Product name
    private By productName = By.xpath(
            "//*[contains(text(),'Alphonso Mangoes')]"
    );

    // Checkout button
   private By checkoutButton = By.xpath(
        "//a[contains(@href,'/checkout') and contains(.,'Proceed to Checkout')]"
);

    // Quantity
    private By quantity = By.xpath(
            "//div[contains(@class,'border')]/span[contains(@class,'font-semibold')]"
    );

    // Plus (+) button
    private By plusButton = By.xpath(
            "//h3[.//a[contains(.,'Alphonso Mangoes')]]" +
            "/following::div[contains(@class,'rounded-lg') and contains(@class,'border')]//button[2]"
    );


// Delete button
private By deleteButton = By.xpath(
        "//h3[.//a[contains(.,'Alphonso Mangoes')]]" +
        "/ancestor::div[contains(@class,'flex') and contains(@class,'rounded-xl') and contains(@class,'border')][1]" +
        "//button[contains(@class,'text-red-400')]"
);

// Click Delete button
public void clickDeleteButton() {
    driver.findElement(deleteButton).click();
}

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartDisplayed() {
        return driver.findElement(shoppingCart).isDisplayed();
    }

    public boolean isProductDisplayed() {
        return driver.findElement(productName).isDisplayed();
    }

    public void clickProceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public String getQuantity() {
        return driver.findElement(quantity).getText();
    }

    public void clickPlusButton() {
        driver.findElement(plusButton).click();
    }
}