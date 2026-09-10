package com.jaikisan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private By shoppingCart = By.xpath(
            "//*[contains(normalize-space(),'Shopping Cart')]"
    );

    private By productName = By.xpath(
            "//*[contains(normalize-space(),'Alphonso Mangoes')]"
    );

    private By checkoutButton = By.xpath(
            "//a[contains(@href,'/checkout') " +
            "and contains(normalize-space(),'Proceed to Checkout')]"
    );

    private By quantity = By.xpath(
            "//div[contains(@class,'border')]" +
            "/span[contains(@class,'font-semibold')]"
    );

    private By deleteButton = By.xpath(
            "//h3[.//a[contains(.,'Alphonso Mangoes')]]" +
            "/ancestor::div[contains(@class,'flex') " +
            "and contains(@class,'rounded-xl') " +
            "and contains(@class,'border')][1]" +
            "//button[contains(@class,'text-red-400')]"
    );

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartDisplayed() {
        return driver.findElement(
                shoppingCart
        ).isDisplayed();
    }

    public boolean isProductDisplayed() {
        return driver.findElement(
                productName
        ).isDisplayed();
    }

    public String getQuantity() {
        return driver.findElement(
                quantity
        ).getText();
    }

    public void clickProceedToCheckout() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        WebElement checkout = wait.until(
                ExpectedConditions.elementToBeClickable(
                        checkoutButton
                )
        );

        checkout.click();
    }

    public void clickPlusButton() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        By productCard = By.xpath(
                "//h3[.//a[contains(.,'Alphonso Mangoes')]]" +
                "/ancestor::div[contains(@class,'rounded-xl') " +
                "and contains(@class,'border')][1]"
        );

        WebElement card = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productCard
                )
        );

        By plusButton = By.xpath(
                ".//button[contains(@class,'rounded-r-lg')]"
        );

        WebElement plus = card.findElement(
                plusButton
        );

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        plus
                );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        plus
                )
        );

        Actions actions = new Actions(driver);

        actions
                .moveToElement(plus)
                .pause(Duration.ofMillis(500))
                .click()
                .perform();
    }

    public void clickDeleteButton() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        WebElement delete = wait.until(
                ExpectedConditions.elementToBeClickable(
                        deleteButton
                )
        );

        delete.click();

        System.out.println(
                "Delete button clicked."
        );
    }
}