package steps;

import steps.hooks.WebDriverHooks;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {
    protected static final String OCADO_URL = "http://www.ocado.com";

    protected WebDriver driver;

    public AbstractSteps() {
        this.driver = WebDriverHooks.getDriver();
    }
}
