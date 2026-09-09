package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.LoginPage;

public class TC12_LoginPageTest extends BaseTest {

    @Test
    public void verifyLoginPage() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Click Login link
        By loginLink = By.xpath("//a[contains(.,'Login')]");

        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        ).click();

        // Wait for Login page
        wait.until(
                ExpectedConditions.urlContains("/login")
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println(
                "Login Page URL: " + currentUrl
        );

        // Verify Login page URL
        Assert.assertTrue(
                currentUrl.contains("/login"),
                "User should be navigated to Login page"
        );

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Verify Welcome Back heading
        Assert.assertTrue(
                loginPage.isWelcomeBackDisplayed(),
                "Welcome Back heading should be displayed"
        );

        System.out.println(
                "TC12: Login page verified successfully."
        );
    }
}