package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class FooterPage extends BasePage {

    private final By iconFacebook = By.cssSelector("a[data-test='social-facebook']");
    private final By iconTwitter = By.cssSelector("a[data-test='social-twitter']");

    @Override
    public void verifyPage() {
        Logs.info("Verify displayed for elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(iconFacebook).isDisplayed()),
                () -> Assertions.assertTrue(find(iconTwitter).isDisplayed())
        );
    }

    public void verifyUrlSocialNetwork(String urlFacebook, String urlX) {
        Logs.info("Making assertions of links");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(iconFacebook).isDisplayed(), "icon facebook"),
                () -> Assertions.assertTrue(find(iconFacebook).isEnabled()),
                () -> Assertions.assertEquals(find(iconFacebook).getDomAttribute("href"), urlFacebook),

                () -> Assertions.assertTrue(find(iconTwitter).isDisplayed()),
                () -> Assertions.assertTrue(find(iconTwitter).isEnabled()),
                () -> Assertions.assertEquals(find(iconTwitter).getDomAttribute("href"), urlX)
        );
    }
}
