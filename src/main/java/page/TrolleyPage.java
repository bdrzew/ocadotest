package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class TrolleyPage extends AbstractPage {

    @FindBy(css = "#basketSummaryTotal")
    WebElement basketSummaryTotal;
    @FindBy(css = "#basketSummarySavings")
    WebElement basketSummarySavings;

    public TrolleyPage(WebDriver driver) {
        super(driver);
    }
}
