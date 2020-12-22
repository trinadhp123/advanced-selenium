package test.java.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ShoppingCartPage {
    private RemoteWebDriver driver;
    private static String url = "https://www.saucedemo.com/cart.html";


    public ShoppingCartPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ShoppingCartPage() {
        super();
    }

    public InformationPage checkOut() {
        return new InformationPage();
    }

    public CheckoutSignIn checkOutSignIn() {
        return new CheckoutSignIn();
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(url);
    }
}
