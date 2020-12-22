package test.java.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PageFactory {
    private RemoteWebDriver driver;

    public PageFactory(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public AddressBookPage addressBookPage() {
        if (driver.manage().window().getSize().width < 992) {
            return AddressBookMobilePage.visit(driver);
        } else {
            return AddressBookPage.visit(driver);
        }
    }
}
