package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static WebDriverFactory instance;

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    public WebDriver createDriver(String browser) {
        return DriverEnum.valueOf(browser.toUpperCase()).getDriver();
    }

    private enum DriverEnum{
        FIREFOX;

        public WebDriver getDriver() {
            switch(this){
                case FIREFOX:
                default:
                    return new FirefoxDriver();
            }
        }
    }

}
