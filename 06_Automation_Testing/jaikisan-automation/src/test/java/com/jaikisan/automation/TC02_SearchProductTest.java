package com.jaikisan.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.HomePage;

public class TC02_SearchProductTest extends BaseTest {

    @Test
    public void verifyProductSearch() {

        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("Tomato");

        String pageText = driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(
                pageText.toLowerCase().contains("tomato"),
                "Tomato search results should be displayed"
        );

        System.out.println(
                "TC02: Tomato search executed successfully."
        );
    }
}