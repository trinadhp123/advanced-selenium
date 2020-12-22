package test.java;

import org.junit.Assert;
import org.junit.Test;
import test.java.data.User;
import test.java.pages.SauceDemoPage;

public class SuccessHandlingTest extends SauceTestBase {

    @Test
    public void testAssertsValue() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.login(User.invalid());
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void testAssertsPOBoolean() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.login(User.invalid());
        Assert.assertTrue(sauceDemoPage.loginSuccessful());
    }

    @Test
    public void testAssertsBadPOBoolean() throws InterruptedException {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.login(User.invalid());
        Assert.assertTrue(sauceDemoPage.badLoginSuccessful());
    }

    @Test
    public void testValidatesPOException() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.login(User.invalid());

        try {
            sauceDemoPage.validateSuccess();
        } catch (Exception e) {
            Assert.fail("Login not successful");
        }
    }

    @Test
    public void pageObjectMethodValidates() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);

        try {
            sauceDemoPage.loginSuccessfully(User.invalid());
        } catch (Exception e) {
            Assert.fail("Login not successful");
        }
    }

    @Test(expected = Test.None.class)
    public void pageObjectMethodValidatesWithMessage() throws Exception {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.loginSuccessfully(User.invalid());
    }

    @Test
    public void findMissingElementDefaultMessage() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.locateMissingElementDefaultError();
    }

    @Test
    public void findMissingElementCustomMessage() {
        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.locateMissingElementCustomError();
    }
}
