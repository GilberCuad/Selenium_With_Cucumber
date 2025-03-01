package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBarPage extends BasePage {

    private final By numberItems = By.cssSelector("span[data-test=shopping-cart-badge]");
    private final By buttonBurgerMenu = By.id("react-burger-menu-btn");

    @Override
    public void verifyPage() {
        Logs.info("Verify displayed for elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(numberItems).isDisplayed()),
                () -> Assertions.assertTrue(find(buttonBurgerMenu).isDisplayed())
        );
    }

    public void itemInCart(int numberElements) {
        Logs.info("Verify number items the shopping cart");

        final var numberItem = find(numberItems).getText();
        Assertions.assertEquals(Integer.parseInt(numberItem), numberElements);
    }

    public void openBurgerMenu() {
        Logs.info("Open burger menu");
        find(buttonBurgerMenu).click();
        sleep(1500);
    }
}
