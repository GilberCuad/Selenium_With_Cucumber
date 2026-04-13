package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    private final By loginTittle = By.className("login_logo");

    public void browseUrl(String url) {
        getDriver().get(url);
    }

    @Override
    public void verifyPage() {
        Logs.info("Verifies the login page");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(usernameInput).isDisplayed(), "Username error"),
                () -> Assertions.assertTrue(find(passwordInput).isDisplayed()),
                () -> Assertions.assertTrue(find(loginButton).isDisplayed()),
                () -> Assertions.assertTrue(find(loginTittle).isDisplayed())
        );
    }

    public void fillForm(String username, String password) {
        Logs.info("The user write username %s ", username);
        find(usernameInput).sendKeys(username);

        Logs.info("The user write password %s ", password);
        find(passwordInput).sendKeys(password);

        Logs.info("The user click button login");
        find(loginButton).click();
    }

    public void verifyErrorMessage(String errorMessageSend) {
        Logs.info("Verifies that visible, see message");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(errorMessage).isDisplayed()),
                () -> Assertions.assertEquals(find(errorMessage).getText(), errorMessageSend)
        );
    }
}
