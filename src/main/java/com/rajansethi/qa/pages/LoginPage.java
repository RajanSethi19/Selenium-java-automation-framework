package com.rajansethi.qa.pages;

import com.rajansethi.qa.base.BasePage;
import org.openqa.selenium.By;

/**
 * Page Object for the SauceDemo login page.
 * Locators and actions for this page live here only -
 * tests call these methods and never touch locators directly.
 */
public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    /** Successful login takes the user to the Inventory page. */
    public InventoryPage clickLoginExpectingSuccess() {
        click(loginButton);
        return new InventoryPage();
    }

    /** Failed login stays on this page and shows an error. */
    public LoginPage clickLoginExpectingFailure() {
        click(loginButton);
        return this;
    }

    public InventoryPage loginSuccessfullyAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLoginExpectingSuccess();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}
