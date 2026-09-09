package com.jaikisan.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jaikisan.automation.pages.LoginPage;
import com.jaikisan.automation.pages.RegisterPage;

public class TC14_RegistrationFormFieldsTest extends BaseTest {

    @Test
    public void verifyRegistrationFormFields() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        // Click Login
        By loginLink = By.xpath("//a[contains(.,'Login')]");

        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/login")
        );

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Click Register
        loginPage.clickRegister();

        // Wait for Register page
        wait.until(
                ExpectedConditions.urlContains("/register")
        );

        // Create Register Page object
        RegisterPage registerPage = new RegisterPage(driver);

        // Verify Full Name field
        Assert.assertTrue(
                registerPage.isFullNameDisplayed(),
                "Full Name field should be displayed"
        );

        // Verify Phone Number field
        Assert.assertTrue(
                registerPage.isPhoneNumberDisplayed(),
                "Phone Number field should be displayed"
        );

        // Verify Verify Phone button
        Assert.assertTrue(
                registerPage.isVerifyPhoneDisplayed(),
                "Verify Phone button should be displayed"
        );

        // Verify Email field
        Assert.assertTrue(
                registerPage.isEmailDisplayed(),
                "Email field should be displayed"
        );

        // Verify Password field
        Assert.assertTrue(
                registerPage.isPasswordDisplayed(),
                "Password field should be displayed"
        );

        // Verify Create Account button
        Assert.assertTrue(
                registerPage.isCreateAccountDisplayed(),
                "Create Account button should be displayed"
        );

        System.out.println(
                "TC14: Registration form fields verified successfully."
        );
    }
}