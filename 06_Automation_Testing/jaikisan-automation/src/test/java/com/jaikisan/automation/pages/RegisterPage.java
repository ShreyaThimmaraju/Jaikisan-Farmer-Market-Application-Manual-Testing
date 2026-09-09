package com.jaikisan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    // Full Name field
    private By fullNameField = By.xpath(
            "//input[@placeholder='Your name']"
    );

    // Phone Number field
    private By phoneNumberField = By.xpath(
            "//input[@placeholder='10-digit number']"
    );

    // Verify Phone button
    private By verifyPhoneButton = By.xpath(
            "//button[contains(.,'Verify Phone')]"
    );

    // Email field
    private By emailField = By.xpath(
            "//input[@type='email']"
    );

    // Password field
    private By passwordField = By.xpath(
            "//input[@type='password']"
    );

    // Create Account button
    private By createAccountButton = By.xpath(
            "//button[contains(.,'Create Account')]"
    );

    // WebDriverWait
    private WebDriverWait wait;

    // Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // Enter Full Name
    public void enterFullName(String name) {
        driver.findElement(fullNameField).sendKeys(name);
    }

    // Enter Phone Number
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Click Verify Phone
    public void clickVerifyPhone() {
        driver.findElement(verifyPhoneButton).click();
    }

    // Enter Email
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Enter Password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click Create Account
    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    // Check Create Account button is enabled
    public boolean isCreateAccountEnabled() {
        return driver.findElement(createAccountButton).isEnabled();
    }

    // Check Verify Phone button is enabled
    public boolean isVerifyPhoneEnabled() {
        return driver.findElement(verifyPhoneButton).isEnabled();
    }

    // Check Full Name field is displayed
    public boolean isFullNameDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(fullNameField)
        ).isDisplayed();
    }

    // Check Phone Number field is displayed
    public boolean isPhoneNumberDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneNumberField)
        ).isDisplayed();
    }

    // Check Email field is displayed
    public boolean isEmailDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        ).isDisplayed();
    }

    // Check Password field is displayed
    public boolean isPasswordDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).isDisplayed();
    }

    // Check Create Account button is displayed
    public boolean isCreateAccountDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(createAccountButton)
        ).isDisplayed();
    }

    // Check Verify Phone button is displayed
    public boolean isVerifyPhoneDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(verifyPhoneButton)
        ).isDisplayed();
    }
}