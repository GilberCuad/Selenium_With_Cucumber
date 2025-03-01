package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class TopBarStepDefinitions {

    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }


    @Then("The user verify that the shopping cart has number {int} of items added")
    public void verifyCartShopping(int numberItems) {
        Logs.info("Verify number items the shopping cart");

        final var numberItem = getDriver().findElement(By.cssSelector("span[data-test=shopping-cart-badge]")).getText();

        Assertions.assertEquals(Integer.parseInt(numberItem), numberItems);
    }
}
