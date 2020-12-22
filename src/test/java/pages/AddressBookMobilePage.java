package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookMobilePage extends AddressBookPage {
    protected static By hamburger = By.cssSelector("button.navbar-toggler");

    public static AddressBookMobilePage visit(WebDriver driver) {
        AddressBookMobilePage addressBookMobilePage = new AddressBookMobilePage();
        addressBookMobilePage.driver = driver;

        driver.get("http://a.testaddressbook.com/");
        return addressBookMobilePage;
    }

    @Override
    public void navigateToSignInPage() {
        click(hamburger);
        click(signInLink);
    }
}
