package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InventoryPage {
    private WebDriver driver;

    private static By shoppingCart  = By.className("shopping_cart_link");

    public static InventoryPage visit() {
        return new InventoryPage();
    }

    public InventoryPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public InventoryPage() {
        super();
    }

    public boolean onPage() {
        return true;
    }

    public InventoryPage selectProduct(String s) {
        return this;
    }

    public ShoppingCartPage shoppingCart() {
        return new ShoppingCartPage();
    }

    public void navigateToShoppingCart() {
        driver.findElement(shoppingCart).click();
    }
}
