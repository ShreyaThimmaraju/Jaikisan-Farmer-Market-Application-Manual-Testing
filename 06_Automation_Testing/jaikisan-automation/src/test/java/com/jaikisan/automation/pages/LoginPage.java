package com.jaikisan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Login page heading
    private By welcomeBack = By.xpath(
            "//*[contains(text(),'Welcome Back')]"
    );

    // Phone Number field
    private By phoneNumberField = By.xpath(
            "//input[@type='tel']"
    );

    // Send OTP button
    private By sendOtpButton = By.xpath(
            "//button[contains(.,'Send OTP')]"
    );

    // Register link
    private By registerLink = By.xpath(
            "//a[contains(.,'Register')]"
    );

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Verify Login page heading
    public boolean isWelcomeBackDisplayed() {
        return driver.findElement(welcomeBack).isDisplayed();
    }

    // Enter phone number
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Click Send OTP
    public void clickSendOtp() {
        driver.findElement(sendOtpButton).click();
    }

    // Click Register
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }
}