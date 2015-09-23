package steps.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import webdriver.WebDriverFactory;

public final class WebDriverHooks {
    private static WebDriver driver;
    private static final String BROWSER = "firefox";

    @Before
    public void setup() {
        driver = WebDriverFactory.getInstance().createDriver(BROWSER);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
