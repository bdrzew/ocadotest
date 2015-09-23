package page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.OcadoExpectedConditions;

@Getter
public class HomePage extends AbstractPage {

    private static final String PASSWORD_CSS = "#mainlogin input[type='password']";
    public static final String HEADER_CSS = "#header ";

    @FindBy(css = HEADER_CSS + "#browseShopContainer a")
    private WebElement browseShopTabAnchor;
    @FindBy(css = HEADER_CSS + "#offers a")
    private WebElement openTabAnchor;
    @FindBy(css = HEADER_CSS + "#loginButton")
    private WebElement loginButton;
    @FindBy(css = HEADER_CSS + ".browseMyShop")
    private WebElement myShopTab;

    public HomePage(WebDriver driver) {
        super(driver, null);
    }

    public HomePage(WebDriver driver, String url) {
        super(driver, url);
    }

    public BrowseShopPage openBrowseShopTab() {
        browseShopTabAnchor.click();
        waitForPageToLoad();
        waitUntil(OcadoExpectedConditions.documentIsReady());
        return new BrowseShopPage(driver);
    }

    public OffersPage openOffersTab() {
        openTabAnchor.click();
        waitForPageToLoad();
        waitUntil(OcadoExpectedConditions.documentIsReady());
        return new OffersPage(driver);
    }

    public LoginPage openLoginForm(){
        loginButton.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PASSWORD_CSS)));
        return new LoginPage(driver);
    }
}
