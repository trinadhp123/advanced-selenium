package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage {
    protected WebDriver driver;

    protected static By signInLink = By.id("sign-in");

    public static AddressBookPage visit(WebDriver driver) {
        AddressBookPage addressBookPage = new AddressBookPage();
        addressBookPage.driver = driver;

        driver.get("http://a.testaddressbook.com/");
        return addressBookPage;
    }

    public void navigateToSignInPage() {
        click(signInLink);
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        driver.findElement(locator).click();
    }
}
