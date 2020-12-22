package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.data.User;

import java.util.function.Function;

public class SauceDemoPage {
    private WebDriver driver;

    private static String url = "https://www.saucedemo.com/";
    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By SUBMIT = By.id("login-button");
    private static final By ERROR = By.cssSelector("[data-test=error]");
    private static final By MISSING = By.id("not-an-element");

    public static SauceDemoPage visit(WebDriver driver) {
        SauceDemoPage sauceDemoPage = new SauceDemoPage();
        sauceDemoPage.driver = driver;
        driver.get(url);
        return sauceDemoPage;
    }

    public InventoryPage login(User data) {
        driver.findElement(USERNAME).sendKeys(data.getUserName());
        driver.findElement(PASSWORD).sendKeys(data.getPassword());
        driver.findElement(SUBMIT).click();

        return new InventoryPage();
    }

    public void loginSuccessfully(User data) throws Exception {
        submitForm(data);
        validateSuccess();
    }

    public void submitForm(User data) {
        driver.findElement(USERNAME).sendKeys(data.getUserName());
        driver.findElement(PASSWORD).sendKeys(data.getPassword());
        driver.findElement(SUBMIT).click();
    }

    public boolean loginSuccessful() {
        return !driver.getCurrentUrl().equals(url);
    }

    public void validateSuccess() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until((Function<WebDriver, Object>) driver -> loginSuccessful());
        } catch (TimeoutException e) {
            String message = driver.findElement(ERROR).getText();
            throw new Exception("Login was not successful after 5 seconds: " + message);
        }
    }

    public boolean badLoginSuccessful() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElements(ERROR).size() == 0;
    }

    public void locateMissingElementDefaultError() {
        driver.findElement(MISSING);
    }

    public void locateMissingElementCustomError() {
        try {
            driver.findElement(MISSING);
        } catch (NoSuchElementException e) {
            String msg = "Element 'MISSING' not found in SauceDemoPage when executing " +
                    "'locateMissingElementCustomError()'";
            throw new NoSuchElementException(msg + "; " + e.getMessage());
        }
    }
}
