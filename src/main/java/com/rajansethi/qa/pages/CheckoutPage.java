package com.rajansethi.qa.pages;

import com.rajansethi.qa.base.BasePage;
import org.openqa.selenium.By;

/**
 * Page Object for the SauceDemo checkout flow:
 * your information -> overview -> complete.
 */
public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector("[data-test='complete-header']");

    public CheckoutPage fillYourInformation(String firstName, String lastName, String postalCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);
        click(continueButton);
        return this;
    }

    public CheckoutPage clickFinish() {
        click(finishButton);
        return this;
    }

    public String getCompleteMessage() {
        return getText(completeHeader);
    }
}
