package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    protected WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public abstract void verifyPage();

    protected void sleep(int ms) {
        Logs.info("Waiting for order by page");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException interruptedException) {
        }
    }
}
