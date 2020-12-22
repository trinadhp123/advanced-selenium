package test.java.pages;

import test.java.data.User;

public class SauceDemoPage {
    public static SauceDemoPage visit() {
        return new SauceDemoPage();
    }

    public InventoryPage login(User data) {
        return new InventoryPage();
    }
}
