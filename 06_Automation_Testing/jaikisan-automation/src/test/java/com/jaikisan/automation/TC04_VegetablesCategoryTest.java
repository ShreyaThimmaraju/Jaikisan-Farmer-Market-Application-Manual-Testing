package com.jaikisan.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_VegetablesCategoryTest extends BaseTest {

    @Test
    public void verifyVegetablesCategory() throws InterruptedException {

        By vegetablesLink = By.xpath("//a[contains(.,'Vegetables')]");

        driver.findElement(vegetablesLink).click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        String pageText = driver.findElement(By.tagName("body")).getText();

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Vegetables Category Page:");

        Assert.assertTrue(
                pageText.toLowerCase().contains("vegetable"),
                "Vegetables category should be displayed"
        );

        System.out.println("TC04: Vegetables category verified successfully.");
    }
}