package steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class FooterStepDefinitions {
    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }


    @Then("The user verify that the button is correct with url {string} and {string}")
    public void verifySocialNetwork(String urlFacebook, String urlX) {
        final var buttonFacebook = getDriver().findElement(By.cssSelector("a[data-test='social-facebook']"));
        final var buttonX = getDriver().findElement(By.cssSelector("a[data-test='social-twitter']"));

        Logs.info("Making assertions of links");
        Assertions.assertAll(
                () -> Assertions.assertTrue(buttonFacebook.isDisplayed()),
                () -> Assertions.assertTrue(buttonFacebook.isEnabled()),
                () -> Assertions.assertEquals(buttonFacebook.getDomAttribute("href"), urlFacebook),

                () -> Assertions.assertTrue(buttonX.isDisplayed()),
                () -> Assertions.assertTrue(buttonX.isEnabled()),
                () -> Assertions.assertEquals(buttonX.getDomAttribute("href"), urlX)
        );
    }
}
