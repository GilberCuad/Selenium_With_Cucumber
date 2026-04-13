package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Logs;
import utilities.WebDriverProvider;

import java.time.Duration;

public class Hooks {
    private static WebDriver driver;

    @Before
    public static void before(Scenario scenario) {
        Logs.info("Initialized driver");

        ChromeOptions options = new ChromeOptions();

        // Activa headless si se pasa -Dheadless=true (necesario en Jenkins/Docker)
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            Logs.debug("Running in headless mode");
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        Logs.debug("Maximized display");
        driver.manage().window().maximize();

        Logs.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Adding implicit wait");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Logs.debug("Saving driver initialized");
        new WebDriverProvider().set(driver);
    }

    @After
    public static void after(Scenario scenario) {
        Logs.info("Dead driver");
        driver.quit();
    }
}