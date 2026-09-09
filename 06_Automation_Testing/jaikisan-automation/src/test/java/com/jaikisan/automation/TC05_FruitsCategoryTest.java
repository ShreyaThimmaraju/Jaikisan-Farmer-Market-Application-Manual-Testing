package com.jaikisan.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_FruitsCategoryTest extends BaseTest {

    @Test
    public void verifyFruitsCategory() throws InterruptedException {

        By fruitsLink = By.xpath("//a[contains(.,'Fruits')]");

        driver.findElement(fruitsLink).click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        String pageText = driver.findElement(By.tagName("body")).getText();

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Fruits Category Page:");

        Assert.assertTrue(
                pageText.toLowerCase().contains("fruits"),
                "Fruits category should be displayed"
        );

        System.out.println("TC05: Fruits category verified successfully.");
    }
}