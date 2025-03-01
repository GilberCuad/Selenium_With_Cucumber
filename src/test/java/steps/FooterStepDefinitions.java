package steps;

import io.cucumber.java.en.Then;
import pages.FooterPage;

public class FooterStepDefinitions {
    private final FooterPage footerPage = new FooterPage();


    @Then("The user verify that the button is correct with url {string} and {string}")
    public void verifySocialNetwork(String urlFacebook, String urlX) {
        footerPage.verifyUrlSocialNetwork(urlFacebook, urlX);
    }
}
