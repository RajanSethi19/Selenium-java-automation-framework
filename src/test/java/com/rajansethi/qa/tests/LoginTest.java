package com.rajansethi.qa.tests;

import com.rajansethi.qa.pages.InventoryPage;
import com.rajansethi.qa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Login tests for SauceDemo.
 * Valid credentials come from config.properties.
 * Invalid combinations are supplied by the DataProvider below.
 */
public class LoginTest extends BaseTest {

    @Test(description = "Valid user can log in and reaches the Products page")
    public void validUserCanLogin() {
        InventoryPage inventoryPage = loginPage.loginSuccessfullyAs(
                ConfigReader.get("username"),
                ConfigReader.get("password"));

        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page did not load after login");
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][]{
                // username, password, expected part of the error message
                {"locked_out_user", "secret_sauce", "locked out"},
                {"standard_user", "wrong_password", "do not match"},
                {"", "secret_sauce", "Username is required"},
                {"standard_user", "", "Password is required"},
        };
    }

    @Test(dataProvider = "invalidLogins", description = "Invalid logins show the correct error message")
    public void invalidLoginShowsError(String username, String password, String expectedError) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginExpectingFailure();

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message was not displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedError),
                "Expected error to contain '" + expectedError + "' but was: " + loginPage.getErrorMessage());
    }
}
