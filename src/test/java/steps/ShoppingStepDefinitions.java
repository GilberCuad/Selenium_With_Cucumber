package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
    }

    @Then("Verifies the page login UI shopping")
    public void verifiesThePageLoginUIShopping() {

        Logs.info("Assertions");

        Assertions.assertAll(
                () -> Assertions.assertTrue(getDriver().findElement(By.className("app_logo")).isDisplayed(), "Swag Labs Title"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("span[data-test='title']")).isDisplayed(), "Products title"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("select[data-test='product-sort-container']")).isDisplayed(), "Container products"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("div[data-test='inventory-list']")).isDisplayed(), "List container"),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("shopping_cart_container")).isDisplayed(), "Shopping car container"),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("react-burger-menu-btn")).isDisplayed(), "Burger menu")
        );
    }

    @When("The user add all item to car")
    public void addAllItemToCart() {
        Logs.info("Adding all items to cart");

        final var listElements = getDriver().findElements(By.xpath("//button[text()='Add to cart']"));

        for (var webElements : listElements) {
            webElements.click();
        }
    }

    @And("The user browse to page shopping")
    public void browseToPageShopping() {

        Logs.info("The user write username");
        getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        Logs.info("The user write password");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");

        Logs.info("The click on the button login");
        getDriver().findElement(By.id("login-button")).click();
    }

    @And("The user click in first element")
    public void clickInFirstElement() {
        Logs.info("Click on the first image");
        getDriver().findElements(By.cssSelector("img.inventory_item_img")).get(0).click();
    }

    @Then("The user verify that back shopping page")
    public void verifyThatBackShoppingPage() {
        Logs.info("Assertions on shopping page");

        Assertions.assertAll(
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("select[data-test='product-sort-container']")).isDisplayed(), "Container products"),
                () -> Assertions.assertTrue(getDriver().findElement(By.cssSelector("div[data-test='inventory-list']")).isDisplayed(), "List container"));
    }

    @When("The user sort the items descending by name")
    public void theItemsDescendingByName() {
        Logs.info("The user sort the items descending by name");

        final var selectElements = getDriver().findElement(By.cssSelector("select[data-test='product-sort-container']"));
        final var select = new Select(selectElements);

        select.selectByValue("za"); // selection value
    }

    @Then("The user verify that the first item be {string} and the last item be {string}")
    public void verifyFirstAndLastName(String nameFirst, String nameSecond) {
        final var listElements = getDriver().findElements(By.cssSelector("div[data-test='inventory-item-name']"));
        final var firstElement = listElements.get(0).getText();
        final var lastElement = listElements.get(listElements.size() - 1).getText();

        Assertions.assertAll(
                () -> Assertions.assertEquals(nameFirst, firstElement),
                () -> Assertions.assertEquals(nameSecond, lastElement)
        );

    }

    @When("The user sort the items ascend by price")
    public void theItemsAscendByPrice() {

        Logs.info("The user sort the items ascend by price");

        final var selectElements = getDriver().findElement(By.cssSelector("select[data-test='product-sort-container']"));
        final var select = new Select(selectElements);

        select.selectByValue("lohi"); // selection value
    }

    @Then("The user verify that the price first item be {string} and the last price item be {string}")
    public void verifyPriceFirsAndLastPrice(String priceFirst, String priceSecond) {

        final var listElements = getDriver().findElements(By.cssSelector("div[data-test='inventory-item-price']"));
        final var firstPrice = listElements.get(0).getText();
        final var lastPrice = listElements.get(listElements.size() - 1).getText();

        Assertions.assertAll(
                () -> Assertions.assertEquals(priceFirst, firstPrice),
                () -> Assertions.assertEquals(priceSecond, lastPrice)
        );
    }

    @And("The user waits while the page is being organized")
    public void waitOrganizedPage() {
        Logs.info("Waiting for order by page");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException interruptedException) {
        }

    }
}
