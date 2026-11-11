package com.rajansethi.qa.pages;

import com.rajansethi.qa.base.BasePage;
import org.openqa.selenium.By;

/**
 * Page Object for the SauceDemo cart page.
 */
public class CartPage extends BasePage {

    private final By cartItemNames = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public int getCartItemCount() {
        return driver.findElements(cartItemNames).size();
    }

    public String getFirstItemName() {
        return getText(cartItemNames);
    }

    public CheckoutPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutPage();
    }
}
