package com.rajansethi.qa.pages;

import com.rajansethi.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Page Object for the SauceDemo inventory (products) page,
 * shown after a successful login.
 */
public class InventoryPage extends BasePage {

    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By productNames = By.cssSelector(".inventory_item_name");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isLoaded() {
        return isDisplayed(pageTitle);
    }

    public int getProductCount() {
        waitForVisible(productNames);
        List<WebElement> products = driver.findElements(productNames);
        return products.size();
    }

    /** Adds a product to the cart using its SauceDemo product id, e.g. "sauce-labs-backpack". */
    public InventoryPage addProductToCart(String productId) {
        click(By.cssSelector("[data-test='add-to-cart-" + productId + "']"));
        return this;
    }

    public String getCartCount() {
        return getText(cartBadge);
    }

    public CartPage openCart() {
        click(cartLink);
        return new CartPage();
    }
}
