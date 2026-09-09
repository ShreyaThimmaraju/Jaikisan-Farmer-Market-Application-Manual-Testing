package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.LoginPage;
import com.jaikisan.automation.pages.RegisterPage;

public class TC16_InvalidPhoneNumberTest extends BaseTest {

    @Test
    public void verifyInvalidPhoneNumberValidation() {

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

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Click Register link
        loginPage.clickRegister();

        // Wait for Register page
        wait.until(
                ExpectedConditions.urlContains("/register")
        );

        // Create Register Page object
        RegisterPage registerPage = new RegisterPage(driver);

        // Enter Full Name
        registerPage.enterFullName("Test User");

        // Enter invalid phone number
        registerPage.enterPhoneNumber("123");

        // Verify Verify Phone button is displayed
        Assert.assertTrue(
                registerPage.isVerifyPhoneDisplayed(),
                "Verify Phone button should be displayed"
        );

        // Verify Verify Phone button is disabled
        Assert.assertFalse(
                registerPage.isVerifyPhoneEnabled(),
                "Verify Phone button should remain disabled for an invalid phone number"
        );

        // Verify Create Account button is displayed
        Assert.assertTrue(
                registerPage.isCreateAccountDisplayed(),
                "Create Account button should be displayed"
        );

        // Verify Create Account button is disabled
        Assert.assertFalse(
                registerPage.isCreateAccountEnabled(),
                "Create Account button should remain disabled for an invalid phone number"
        );

        System.out.println(
                "TC16: Invalid phone number validation verified successfully."
        );
    }
}