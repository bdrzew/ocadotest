package page;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import assertion.AbstractAssertions;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private static final int PAGE_LOAD_TIMEOUT = 10000;
    private static final int WAIT_TIMEOUT = 10;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this(driver, null);
    }

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        if (isNotBlank(url)) {
            driver.navigate().to(url);
        }
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public <G extends AbstractPage, T extends AbstractAssertions<G>> T check(Class<T> clazz) throws RuntimeException {
        try {
            AbstractAssertions<G> assertion = clazz.newInstance();
            assertion.setPage((G)this);
            return (T) assertion;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error occur during creating Assertions.", e);
        }
    }

    protected void waitForPageToLoad() {
        WaitForPageToLoad wait = new WaitForPageToLoad();
        wait.apply(driver, new String[]{String.valueOf(PAGE_LOAD_TIMEOUT)});
    }

    protected void waitUntil(ExpectedCondition<?> expectedCondition) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(expectedCondition);
    }


}
