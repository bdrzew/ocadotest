package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.OcadoExpectedConditions;

import java.util.List;

public class OffersPage extends AbstractPage {

    @FindBy(css = ".productDetails .productAdd")
    List<WebElement> offers;

    public OffersPage(WebDriver driver) {
        super(driver);
    }

    public OffersPage addFirstThreeOffersToCart() {
        offers.stream().limit(3).forEach(p -> {
            p.click();
            waitUntil(OcadoExpectedConditions.jQueryIsDone());
        });
        return this;
    }
}
