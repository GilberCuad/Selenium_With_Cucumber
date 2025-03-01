package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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

    @And("The user open burger menu")
    public void theUserOpenBurgerMenu() {
        Logs.info("Open burger menu");
        getDriver().findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("The user waits while open the burger menu")
    public void waitBurgerMenu() {
        Logs.info("Waiting burger menu");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException interruptedException) {
        }
    }

    @Then("The user verify the button about with url {string}")
    public void verifyButtonAbout(String url) {
        Logs.info("Verify the button about");

        Assertions.assertTrue(getDriver().findElement(By.id("about_sidebar_link")).isDisplayed(), "Is visible");
    }
}
