package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class LoginStepsDefinitions {

    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    @Given("The user browse the page {string}")
    public void browsePage(String url) {
        Logs.info("Visit the page %s ", url);
        getDriver().get(url);
    }

    @And("The user click on login button")
    public void clickLoginButton() {
        Logs.info("The click on the button login");
        getDriver().findElement(By.id("login-button")).click();
    }

    @Then("The user verifies error message contains text {string}")
    public void verifiesErrorMessage(String textError) {

        final var messagError = getDriver().findElement(By.cssSelector("h3[data-test='error']"));


        Logs.info("Verifies that visible, see message");
        Assertions.assertAll(
                () -> Assertions.assertTrue(messagError.isDisplayed()),
                () -> Assertions.assertEquals(messagError.getText(), textError)
        );
    }

    @Then("Verifies the page login UI")
    public void verifiesPageLoginUI() {
        Logs.info("Verifies the login page");

        Assertions.assertAll(
                () -> Assertions.assertTrue(getDriver().findElement(By.id("user-name")).isDisplayed(), "Username error"),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("password")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.id("login-button")).isDisplayed()),
                () -> Assertions.assertTrue(getDriver().findElement(By.className("login_logo")).isDisplayed())
                );
    }

    @When("The user write the username {string} and write the password {string}")
    public void loginUser(String username, String password) {
        Logs.info("The user write username %s ", username);
        getDriver().findElement(By.id("user-name")).sendKeys(username);

        Logs.info("The user write password %s ", password);
        getDriver().findElement(By.id("password")).sendKeys(password);
    }
}
