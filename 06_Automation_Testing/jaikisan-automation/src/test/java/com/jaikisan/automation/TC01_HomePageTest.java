package com.jaikisan.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.HomePage;

public class TC01_HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {

        HomePage homePage = new HomePage(driver);

        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(
                actualTitle,
                "Jaikisan Farmer Market | Buy Direct from Farmers Marketplace India"
        );
    }
}