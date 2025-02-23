package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class LoginSaucedemoSteps {
    private String url;

    @Given("The user visit the page {string}")
    public void visitThePage(String url) {
        Logs.info("Visit the page %s", url);
        getDriver().get(url);
    }

    @When("The user get the browser url")
    public void getTheBrowserUrl() {
        Logs.info("Get to url");
        url = getDriver().getCurrentUrl();
    }

    @Then("The user verifies that the current url is equal to {string}")
    public void verifiesEquals(String urlExpected) {
        Assertions.assertEquals(url, urlExpected);
        Logs.info("Verifies to url");
    }

    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    @And("The user visit other page {string}")
    public void visitOtherPage(String url) {
        Logs.info("Visit other page %s", url);
        getDriver().get(url);
    }

    @And("The user back page with driver")
    public void backPageWithDriver() {
      Logs.info("The user back page with driver");
      getDriver().navigate().back();
    }

    @Then("The user verifies that the url is {string}")
    public void verifiesThatTheUrlIs(String urlExpected) {
       Assertions.assertEquals(url, urlExpected);
    }
}
