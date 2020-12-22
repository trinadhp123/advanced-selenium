package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.data.User;

public class MagicInventoryPage {
    private WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/inventory.html";

    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By SUBMIT = By.id("login-button");

    private static final By SHOPPING_CART = By.className("shopping_cart_link");

    public static MagicInventoryPage visitImperative(WebDriver driver) {
        MagicInventoryPage magicInventoryPage = new MagicInventoryPage();
        magicInventoryPage.driver = driver;

        driver.get("https://www.saucedemo.com");
        driver.findElement(USERNAME).sendKeys(User.valid().getUserName());
        driver.findElement(PASSWORD).sendKeys(User.valid().getPassword());
        driver.findElement(SUBMIT).click();

        return magicInventoryPage;
    }

    public static MagicInventoryPage visitDeclarative(WebDriver driver) {
        MagicInventoryPage magicInventoryPage = new MagicInventoryPage();
        magicInventoryPage.driver = driver;

        SauceDemoPage sauceDemoPage = SauceDemoPage.visit(driver);
        sauceDemoPage.login(User.valid());

        return magicInventoryPage;
    }

    public static MagicInventoryPage visitDirect(WebDriver driver) {
        MagicInventoryPage magicInventoryPage = new MagicInventoryPage();
        magicInventoryPage.driver = driver;

        driver.get(URL);

        return magicInventoryPage;
    }

    public MagicInventoryPage() {
        // Does not do anything by default
    }

    public MagicInventoryPage(WebDriver driver) {
        this.driver = driver;

        driver.get("https://www.saucedemo.com");
        driver.findElement(USERNAME).sendKeys(User.valid().getUserName());
        driver.findElement(PASSWORD).sendKeys(User.valid().getPassword());
        driver.findElement(SUBMIT).click();
    }

    public boolean isOnPage() {
        return URL.equals(driver.getCurrentUrl());
    }

    public void shoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }
}
