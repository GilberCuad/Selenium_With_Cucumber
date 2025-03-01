package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBarPage extends BasePage {

    private final By numberItems = By.cssSelector("span[data-test=shopping-cart-badge]");

    @Override
    public void verifyPage() {
        Logs.info("Verify number items the shopping cart");

        final var numberItem = find(numberItems).getText();
        Assertions.assertEquals(Integer.parseInt(numberItem), 6);
    }
}
