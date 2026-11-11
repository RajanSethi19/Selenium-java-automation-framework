package com.rajansethi.qa.tests;

import com.rajansethi.qa.pages.CartPage;
import com.rajansethi.qa.pages.CheckoutPage;
import com.rajansethi.qa.pages.InventoryPage;
import com.rajansethi.qa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * End-to-end purchase flow:
 * login -> add product to cart -> verify cart -> checkout -> order complete.
 */
public class CartCheckoutTest extends BaseTest {

    @Test(description = "User can add the backpack to the cart")
    public void addProductToCart() {
        InventoryPage inventoryPage = loginPage.loginSuccessfullyAs(
                ConfigReader.get("username"),
                ConfigReader.get("password"));

        Assert.assertEquals(inventoryPage.getProductCount(), 6, "Expected 6 products on the inventory page");

        inventoryPage.addProductToCart("sauce-labs-backpack");
        Assert.assertEquals(inventoryPage.getCartCount(), "1", "Cart badge did not show 1 item");

        CartPage cartPage = inventoryPage.openCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
        Assert.assertEquals(cartPage.getFirstItemName(), "Sauce Labs Backpack");
    }

    @Test(description = "User can buy the bike light end to end")
    public void completeCheckoutEndToEnd() {
        InventoryPage inventoryPage = loginPage.loginSuccessfullyAs(
                ConfigReader.get("username"),
                ConfigReader.get("password"));

        CartPage cartPage = inventoryPage
                .addProductToCart("sauce-labs-bike-light")
                .openCart();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.fillYourInformation("Rajan", "Sethi", "L5M 0A1");
        checkoutPage.clickFinish();

        Assert.assertEquals(checkoutPage.getCompleteMessage(), "Thank you for your order!");
    }
}
