package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class ShoppingStepDefinitions {

    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    @Given("The user browse the page shopping {string}")
    public void browseThePageShopping(String url) {
        Logs.info("Visit the page %s ", url);
        getDriver().get(url);

        Logs.info("The user write username");
        getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        Logs.info("The user write password");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");

        Logs.info("The click on the button login");
        getDriver().findElement(By.id("login-button")).click();
    }

    @Then("Verifies the page login UI shopping")
    public void verifiesThePageLoginUIShopping() {

        Logs.info("Assertions");

        Assertions.assertAll(
                () -> Assertions.assertTrue(getDriver().findElement(By.className("app_logo")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("span[data-test='title']")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("select[data-test='product-sort-container']")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("div[data-test='inventory-list']")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("shopping_cart_container")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("react-burger-menu-btn")).isDisplayed())
        );
    }
}
