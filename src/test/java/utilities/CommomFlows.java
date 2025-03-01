package utilities;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ShoppingPage;
import pages.TopBarPage;

public class CommomFlows {
    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    public void goToLoginPage() {
        getDriver().get("https://www.saucedemo.com/");
    }

    public void gotoShoppingPage() {
        goToLoginPage();
        new LoginPage().fillForm("standard_user", "secret_souce");
    }

    public void openBurgerMenu() {
        // adjust for use
        goToLoginPage();
        new TopBarPage().openBurgerMenu();
    }

    public void gotoItemsDetails(int index) {
        gotoShoppingPage();
        new ShoppingPage().clickItemByIndex(index);
    }

}
