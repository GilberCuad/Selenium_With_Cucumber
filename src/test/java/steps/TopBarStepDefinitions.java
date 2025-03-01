package steps;

import io.cucumber.java.en.Then;
import pages.TopBarPage;

public class TopBarStepDefinitions {

    private final TopBarPage topBarPage = new TopBarPage();

    @Then("The user verify that the shopping cart has number {int} of items added")
    public void verifyCartShopping(int numberItems) {
        topBarPage.verifyPage();
    }

}
