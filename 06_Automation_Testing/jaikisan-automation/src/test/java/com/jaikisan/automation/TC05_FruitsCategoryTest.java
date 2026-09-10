package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_FruitsCategoryTest extends BaseTest {

    @Test
    public void verifyFruitsCategory() {

        By fruitsLink = By.xpath("//a[contains(.,'Fruits')]");

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Click Fruits
        wait.until(
                ExpectedConditions.elementToBeClickable(fruitsLink)
        ).click();

        // Wait for Fruits category page
        wait.until(
                ExpectedConditions.urlContains("/categories/fruits")
        );

        String currentUrl = driver.getCurrentUrl();

        String pageText = driver.findElement(
                By.tagName("body")
        ).getText();

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Fruits Category Page:");

        Assert.assertTrue(
                pageText.toLowerCase().contains("fruits"),
                "Fruits category should be displayed"
        );

        System.out.println(
                "TC05: Fruits category verified successfully."
        );
    }
}