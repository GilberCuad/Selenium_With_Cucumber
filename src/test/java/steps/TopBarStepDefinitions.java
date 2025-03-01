package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.TopBarPage;


public class TopBarStepDefinitions {

  private final TopBarPage topBasePage = new TopBarPage();

    @Then("The user verify that the shopping cart has number {int} of items added")
    public void verifyCartShopping(int numberItems) {
       topBasePage.itemInCart(numberItems);
    }

    @And("The user open burger menu")
    public void theUserOpenBurgerMenu() {
       topBasePage.openBurgerMenu();
    }
}
