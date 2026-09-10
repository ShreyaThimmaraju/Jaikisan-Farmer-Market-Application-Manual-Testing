package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_VegetablesCategoryTest extends BaseTest {

    @Test
    public void verifyVegetablesCategory() {

        By vegetablesLink = By.xpath("//a[contains(.,'Vegetables')]");

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        wait.until(driver -> {
            try {
                driver.findElement(vegetablesLink).click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });

        wait.until(driver ->
                driver.getCurrentUrl().contains("/categories/vegetables")
        );

        String currentUrl = driver.getCurrentUrl();

        String pageText = driver.findElement(
                By.tagName("body")
        ).getText();

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Vegetables Category Page:");

        Assert.assertTrue(
                pageText.toLowerCase().contains("vegetable"),
                "Vegetables category should be displayed"
        );

        System.out.println(
                "TC04: Vegetables category verified successfully."
        );
    }
}