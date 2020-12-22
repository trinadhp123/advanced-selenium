package test.java.pages;

public class InventoryPage {
    public static InventoryPage visit() {
        return new InventoryPage();
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
}
