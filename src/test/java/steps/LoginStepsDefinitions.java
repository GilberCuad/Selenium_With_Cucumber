package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepsDefinitions {

    private final LoginPage loginPage = new LoginPage();

    @Then("The user verifies error message contains text {string}")
    public void verifiesErrorMessage(String textError) {
        loginPage.verifyErrorMessage(textError);
    }

    @Then("Verifies the page login UI")
    public void verifiesPageLoginUI() {
        loginPage.verifyPage();
    }

    @When("The user write the username {string} and write the password {string}")
    public void loginUser(String username, String password) {
        loginPage.fillForm(username, password);
    }

    @Given("The user browse the page {string}")
    public void theUserBrowseThePage(String url) {
      loginPage.browseUrl(url);
    }
}
