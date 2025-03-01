package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {
    private final By title = By.className("app_logo");
    private final By productTitle = By.cssSelector("span[data-test='title']");
    private final By containerProducts = By.cssSelector("select[data-test='product-sort-container']");
    private final By listProducts = By.cssSelector("div[data-test='inventory-list']");
    private final By shoppingCart = By.id("shopping_cart_container");
    private final By burgerMenu = By.id("react-burger-menu-btn");

    private final By buttonsAddToCart = By.xpath("//button[text()='Add to cart']");
    private final By itemFirstIndex = By.cssSelector("img.inventory_item_img");
    private final By selectProducts = By.cssSelector("select[data-test='product-sort-container']");
    private final By selectAscendPrice = By.cssSelector("select[data-test='product-sort-container']");
    private final By itemNames = By.cssSelector("div[data-test='inventory-item-name']");
    private final By itemPrices = By.cssSelector("div[data-test='inventory-item-price']");



    @Override
    public void verifyPage() {
        Logs.info("Assertions");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(title).isDisplayed(), "Swag Labs Title"),
                () -> Assertions.assertTrue(find(productTitle).isDisplayed(), "Products title"),
                () -> Assertions.assertTrue(find(containerProducts).isDisplayed(), "Container products"),
                () -> Assertions.assertTrue(find(listProducts).isDisplayed(), "List container"),
                () -> Assertions.assertTrue(find(shoppingCart).isDisplayed(), "Shopping car container"),
                () -> Assertions.assertTrue(find(burgerMenu).isDisplayed(), "Burger menu")
        );
    }

    public void addAllItems() {
        Logs.info("Adding all items to cart");

        final var listElements = findAll(buttonsAddToCart);

        for (var webElements : listElements) {
            webElements.click();
        }
    }

    public void clickItemByIndex(int i) {
        Logs.info("Click on the first image");
        findAll(itemFirstIndex).get(i).click();
    }

    public void orderItemsDescendName() {
        Logs.info("The user sort the items descending by name");

        final var selectElement = find(selectProducts);
        final var select = new Select(selectElement);

        select.selectByValue("za"); // selection value

        sleep(1500);
    }

    public void orderItemsAscendPrice() {
        Logs.info("The user sort the items descending by name");

        final var selectElements = find(selectAscendPrice);
        final var select = new Select(selectElements);

        select.selectByValue("lohi"); // selection value

        sleep(1500);
    }

    public void verifyFistAndEndName(String nameFirst, String nameSecond) {
        Logs.info("Verify first and last element name");
        final var listElements = findAll(itemNames);
        final var firstElement = listElements.get(0).getText();
        final var lastElement = listElements.get(listElements.size() - 1).getText();

        Assertions.assertAll(
                () -> Assertions.assertEquals(nameFirst, firstElement),
                () -> Assertions.assertEquals(nameSecond, lastElement)
        );
    }

    public void verifyFistPriceAndEndPrice(String priceFirst, String priceSecond) {
        Logs.info("Verify first and last element price");
        final var listElements = findAll(itemPrices);
        final var firstPrice = listElements.get(0).getText();
        final var lastPrice = listElements.get(listElements.size() - 1).getText();

        Assertions.assertAll(
                () -> Assertions.assertEquals(priceFirst, firstPrice),
                () -> Assertions.assertEquals(priceSecond, lastPrice)
        );
    }
}