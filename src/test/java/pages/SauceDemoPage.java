package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.data.User;

public class SauceDemoPage {
    private WebDriver driver;

    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By SUBMIT = By.id("login-button");

    public static SauceDemoPage visit(WebDriver driver) {
        driver.get("https://www.saucedemo.com");
        return new SauceDemoPage();
    }

    public InventoryPage login(User data) {
        driver.findElement(USERNAME).sendKeys(User.valid().getUserName());
        driver.findElement(PASSWORD).sendKeys(User.valid().getPassword());
        driver.findElement(SUBMIT).click();

        return new InventoryPage();
    }
}
