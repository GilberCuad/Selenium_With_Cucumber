package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class ItemDetailsStepDefinitions {

    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    @When("The user click on the button Back to Products")
    public void buttonBackToProducts() {
        Logs.info("Click Back to page Shopping");
        getDriver().findElement(By.id("back-to-products")).click();
    }

    @Then("The user verify elements for product")
    public void verifyElementsForProduct() {
        Logs.info("Verifies items for product");

        Assertions.assertAll(
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("div[data-test=inventory-item-name]")).isDisplayed(), "Title product"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("div[data-test=inventory-item-price]")).isDisplayed(), "Product price"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("div[data-test=inventory-item-desc]")).isDisplayed(), "Description"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("img[data-test=item-sauce-labs-backpack-img]")).isDisplayed(), "Product Image"),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("add-to-cart")).isDisplayed(), "Add button cart")
        );


    }
}
