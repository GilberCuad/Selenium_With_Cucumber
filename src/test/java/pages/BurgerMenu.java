package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class BurgerMenu extends BasePage {
    private final By buttonAbout = By.id("about_sidebar_link");
    private final By buttonLogout = By.id("logout_sidebar_link");
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");


    @Override
    public void verifyPage() {
        Assertions.assertTrue(find(buttonAbout).isDisplayed());
    }

    public void verifyButtonAbout(String url) {
        Logs.info("Verify the button about");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(buttonAbout).isDisplayed()),
                () -> Assertions.assertTrue(find(buttonAbout).isEnabled()),
                () -> Assertions.assertEquals(find(buttonAbout).getDomAttribute("href"), url)
        );
    }

    public void logout() {
        Logs.info("Making click logout");
        find(buttonLogout).click();
    }

    public void verifyHomePage() {
        Logs.info("Verify home page");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(usernameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(passwordInput).isDisplayed())
        );
    }
}
