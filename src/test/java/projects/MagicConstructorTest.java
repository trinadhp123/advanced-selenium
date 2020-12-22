package test.java.projects;

import org.junit.Assert;
import org.junit.Test;
import test.java.LocalTestBase;
import test.java.data.User;
import test.java.pages.MagicInventoryPage;
import test.java.pages.SauceDemoPage;
import test.java.pages.ShoppingCartPage;

public class MagicConstructorTest extends LocalTestBase {

    @Test
    public void autoLogin() {
        MagicInventoryPage magicInventoryPage = new MagicInventoryPage(driver);
        Assert.assertTrue(magicInventoryPage.isOnPage());
    }

    @Test
    public void moveToNewState() {
        MagicInventoryPage magicInventoryPage = new MagicInventoryPage(driver);
        SauceDemoPage.visit(driver);

        // Fails at its purpose of enforcing state
        magicInventoryPage.shoppingCart();
        Assert.assertTrue(new ShoppingCartPage().isOnPage());
    }

    @Test
    public void assumesKnownState() {
        SauceDemoPage.visit(driver).login(User.valid());

        // Shouldn't need to log in again to use this page object
        MagicInventoryPage magicInventoryPage = new MagicInventoryPage(driver);
        magicInventoryPage.shoppingCart();
        Assert.assertTrue(new ShoppingCartPage().isOnPage());
    }

    @Test
    public void visitImperative() {
        MagicInventoryPage magicInventoryPage = MagicInventoryPage.visitImperative(driver);
        magicInventoryPage.shoppingCart();
        Assert.assertTrue(new ShoppingCartPage().isOnPage());
    }

    @Test
    public void visitDeclarative() {
        MagicInventoryPage magicInventoryPage = MagicInventoryPage.visitDeclarative(driver);
        magicInventoryPage.shoppingCart();
        Assert.assertTrue(new ShoppingCartPage().isOnPage());
    }

    @Test
    public void visitDirect() {
        MagicInventoryPage magicInventoryPage = MagicInventoryPage.visitDirect(driver);
        magicInventoryPage.shoppingCart();
        Assert.assertTrue(new ShoppingCartPage().isOnPage());
    }

}

