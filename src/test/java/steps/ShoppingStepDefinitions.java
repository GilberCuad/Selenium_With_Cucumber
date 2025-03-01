package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import pages.ShoppingPage;

public class ShoppingStepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(ShoppingStepDefinitions.class);
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final LoginPage loginPage = new LoginPage();

    @Then("Verifies the page login UI shopping")
    public void verifiesThePageLoginUIShopping() {
        shoppingPage.verifyPage();
    }

    @When("The user add all item to car")
    public void addAllItemToCart() {
        shoppingPage.addAllItems();
    }

    @And("The user browse to page shopping")
    public void browseToPageShopping() {
     loginPage.fillForm("standard_user", "secret_sauce");
    }

    @And("The user click in first element")
    public void clickInFirstElement() {
        shoppingPage.clickItemByIndex(0);
    }

    @Then("The user verify that back shopping page")
    public void verifyThatBackShoppingPage() {
        shoppingPage.verifyPage();
    }

    @When("The user sort the items descending by name")
    public void theItemsDescendingByName() {
        shoppingPage.orderItemsDescendName();
    }

    @Then("The user verify that the first item be {string} and the last item be {string}")
    public void verifyFirstAndLastName(String nameFirst, String nameSecond) {
        shoppingPage.verifyFistAndEndName(nameFirst, nameSecond);
    }

    @When("The user sort the items ascend by price")
    public void theItemsAscendByPrice() {
        shoppingPage.orderItemsAscendPrice();
    }

    @Then("The user verify that the price first item be {string} and the last price item be {string}")
    public void verifyPriceFirsAndLastPrice(String priceFirst, String priceSecond) {
        shoppingPage.verifyFistPriceAndEndPrice(priceFirst, priceSecond);
    }

}
