package test.java.pages;

import org.openqa.selenium.By;
import test.java.element.Element;
import test.java.exceptions.PageValidationException;

public class OverviewPage extends BasePage {
    private static final String URL = "https://www.saucedemo.com/checkout-step-one.html";

    private Element finishButton = getElement("finishButton", By.className("cart_button"));

    public void finishSuccessfully() {
        finishButton.click();
        validateSuccessfulNavigation();
    }

    public void validateSuccessfulNavigation() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(URL)) {
            throw new PageValidationException("Navigation away from Overview Page was not successful; Current URL: " + currentUrl);
        }
    }
}
