package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.LoginPage;
import com.jaikisan.automation.pages.RegisterPage;

public class TC13_RegisterPageTest extends BaseTest {

    @Test
    public void verifyRegisterPage() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Click Login link
        By loginLink = By.xpath("//a[contains(.,'Login')]");

        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/login")
        );

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Click Register link
        loginPage.clickRegister();

        // Wait for Register page
        wait.until(
                ExpectedConditions.urlContains("/register")
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println(
                "Register Page URL: " + currentUrl
        );

        // Verify Register page URL
        Assert.assertTrue(
                currentUrl.contains("/register"),
                "User should be navigated to Register page"
        );

        // Create Register Page object
        RegisterPage registerPage = new RegisterPage(driver);

        // Verify Register page is loaded
        Assert.assertTrue(
                driver.findElement(By.tagName("body"))
                        .getText()
                        .contains("Register"),
                "Register heading should be displayed"
        );

        System.out.println(
                "TC13: Register page verified successfully."
        );
    }
}