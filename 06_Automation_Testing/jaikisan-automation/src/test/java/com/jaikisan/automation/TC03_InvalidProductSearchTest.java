package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_InvalidProductSearchTest extends BaseTest {

    @Test
    public void verifyInvalidProductSearch() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By searchBox = By.xpath(
                "//input[contains(@placeholder,'Search')]"
        );

        // Wait for search box
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        // Find fresh element and enter invalid product
        wait.until(
                ExpectedConditions.elementToBeClickable(searchBox)
        ).sendKeys("XYZ12345", Keys.ENTER);

        // Wait for search results page
        wait.until(
                ExpectedConditions.urlContains("/search")
        );

        // Get updated page text
        String pageText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.tagName("body")
                )
        ).getText();

        System.out.println("Invalid Search Page:");
        System.out.println(pageText);

        Assert.assertTrue(
                pageText.contains("No products found"),
                "No products found message should be displayed"
        );

        System.out.println(
                "TC03: Invalid product search verified successfully."
        );
    }
}