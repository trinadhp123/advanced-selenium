package test.java;

import org.junit.Assert;
import org.junit.Test;
import test.java.data.User;
import test.java.pages.InventoryPage;
import test.java.pages.SauceDemoPage;
import test.java.pages.ShoppingCartPage;

public class OpinionatedMethodsTest extends LocalTestBase {

    @Test
    public void goToCartGood() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.submitForm(User.valid());

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.navigateToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.isOnPage());
    }

    @Test
    public void goToCartBad() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.submitForm(User.invalid());

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.navigateToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.isOnPage());
    }

    @Test
    public void goToCartOpinionated() throws Exception {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.loginSuccessfully(User.invalid());

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.navigateToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.isOnPage());
    }
}
