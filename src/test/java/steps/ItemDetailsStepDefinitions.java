package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemsDetailsPage;

public class ItemDetailsStepDefinitions {

    private final ItemsDetailsPage detailspage = new ItemsDetailsPage();

    @When("The user click on the button Back to Products")
    public void buttonBackToProducts() {
       detailspage.backToProducts();
    }

    @Then("The user verify elements for product")
    public void verifyElementsForProduct() {
        detailspage.verifyPage();
    }
}
