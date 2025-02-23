package hooks;

import io.cucumber.java.*;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Logs;
import utilities.WebDriverProvider;

public class Hooks {
    private static WebDriver driver;

    @Before
    public static void before(Scenario scenario) {
        Logs.info("Initialized driver");
        driver = new ChromeDriver();

        Logs.debug("Maximized display");
        driver.manage().window().maximize();

        Logs.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Saving driver initialized");
        new WebDriverProvider().set(driver);
    }


    @After
    public static void after(Scenario scenario) {
        // Get name and status by scenarios
        // Logs.info("Executing before finalized of scenario: %s, status: %s", scenario.getName(), scenario.getStatus());
        Logs.info("Dead driver");
        driver.quit();
    }
}
