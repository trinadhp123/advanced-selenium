package test.java.projects;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import test.java.SauceTestBase;
import test.java.pages.AddressBookMobilePage;
import test.java.pages.AddressBookPage;
import test.java.pages.PageFactory;

public class DeterminismTest extends SauceTestBase {

    @Test
    public void largeWindow() {
        driver.manage().window().setSize(new Dimension(1200, 900));

        AddressBookPage addressBookPage = AddressBookPage.visit(driver);
        addressBookPage.navigateToSignInPage();

        Assert.assertEquals("http://a.testaddressbook.com/sign_in", driver.getCurrentUrl());
    }

    @Test
    public void smallWindow() {
        driver.manage().window().setSize(new Dimension(800, 600));
        AddressBookPage addressBookPage = AddressBookMobilePage.visit(driver);
        addressBookPage.navigateToSignInPage();

        Assert.assertEquals("http://a.testaddressbook.com/sign_in", driver.getCurrentUrl());
    }

    @Test
    public void largeWindowFactory() {
        driver.manage().window().setSize(new Dimension(1200, 900));
        AddressBookPage addressBookPage = new PageFactory(driver).addressBookPage();
        addressBookPage.navigateToSignInPage();

        Assert.assertEquals("http://a.testaddressbook.com/sign_in", driver.getCurrentUrl());
    }

    @Test
    public void smallWindowFactory() {
        driver.manage().window().setSize(new Dimension(800, 600));
        AddressBookPage addressBookPage = new PageFactory(driver).addressBookPage();
        addressBookPage.navigateToSignInPage();

        Assert.assertEquals("http://a.testaddressbook.com/sign_in", driver.getCurrentUrl());
    }
}
