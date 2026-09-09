package com.jaikisan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Search box
    private By searchBox = By.xpath(
            "//input[contains(@placeholder,'Search')]"
    );

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Search product
    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
    }
}