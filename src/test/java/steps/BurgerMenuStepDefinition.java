package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BurgerMenu;
import pages.TopBarPage;


public class BurgerMenuStepDefinition {
    private final BurgerMenu burgerMenuPage = new BurgerMenu();

    @Then("The user verify the button about with url {string}")
    public void verifyTheButtonAboutWithUrl(String url) {
        burgerMenuPage.verifyButtonAbout(url);
    }

    @When("The user click on the logout button")
    public void clickOnTheLogoutButton() {
        burgerMenuPage.logout();
    }

    @Then("The user verify which is located on the main page")
    public void verifyTheMainPage() {
        burgerMenuPage.verifyHomePage();
    }
}
