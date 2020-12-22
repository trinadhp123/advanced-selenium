package test.java.projects;

import org.junit.Assert;
import org.junit.Test;
import test.java.SauceTestBase;
import test.java.data.User;
import test.java.pages.*;

public class CoupledPOsTest extends SauceTestBase {

    @Test
    public void coupled() {
        Assert.assertTrue(
                SauceDemoPage.visit()
                        .login(User.valid())
                        .selectProduct("Sauce Labs Bolt T-Shirt")
                        .selectProduct("Sauce Labs Fleece Jacket")
                        .shoppingCart()
                        .checkOut()
                        .addInformation()
                        .finish()
                        .isSuccessful());
    }

    @Test
    public void loginCheckout() {
        Assert.assertTrue(
                InventoryPage.visit()
                        .selectProduct("Sauce Labs Bolt T-Shirt")
                        .selectProduct("Sauce Labs Fleece Jacket")
                        .shoppingCart()
                        .checkOutSignIn()
                        .loginToCart(User.valid())
                        .addInformation()
                        .finish()
                        .isSuccessful());
    }

    @Test
    public void twoChains() {
        InventoryPage.visit()
                .selectProduct("Sauce Labs Bolt T-Shirt")
                .selectProduct("Sauce Labs Fleece Jacket")
                .shoppingCart()
                .checkOut();

        CheckoutSignIn checkoutSignIn = new CheckoutSignIn();
        checkoutSignIn.loginToCart(User.valid());

        Assert.assertTrue(
                new InformationPage()
                        .addInformation()
                        .finish()
                        .isSuccessful());
    }

    @Test
    public void deCoupled() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit();
        sauceDemoPage.login(User.valid());

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.selectProduct("Sauce Labs Bolt T-Shirt");
        inventoryPage.selectProduct("Sauce Labs Fleece Jacket");
        inventoryPage.shoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.checkOut();

        InformationPage informationPage = new InformationPage();
        informationPage.addInformation();

        OverviewPage overviewPage = new OverviewPage();
        overviewPage.finish();

        CompletePage completePage = new CompletePage();

        Assert.assertTrue(completePage.isSuccessful());
    }
}
