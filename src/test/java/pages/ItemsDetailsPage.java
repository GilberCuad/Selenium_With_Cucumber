package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ItemsDetailsPage extends BasePage {

    private final By buttonBackProducts = By.id("back-to-products");
    private final By titleProduct = By.cssSelector("div[data-test=inventory-item-price]");
    private final By productPrice = By.cssSelector("div[data-test=inventory-item-desc]");
    private final By productImage = By.cssSelector("img[data-test=item-sauce-labs-backpack-img]");
    private final By buttonCart = By.id("add-to-cart");

    @Override
    public void verifyPage() {
        Logs.info("Verifies items for product");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(buttonBackProducts).isDisplayed(), "Title product"),
                () -> Assertions.assertTrue(find(titleProduct).isDisplayed(), "Product price"),
                () -> Assertions.assertTrue(find(productPrice).isDisplayed(), "Description"),
                () -> Assertions.assertTrue(find(productImage).isDisplayed(), "Product Image"),
                () -> Assertions.assertTrue(find(buttonCart).isDisplayed(), "Add button cart")
        );
    }

    public void backToProducts() {
        Logs.info("Click Back to page Shopping");
        find(buttonBackProducts).click();
    }
}
