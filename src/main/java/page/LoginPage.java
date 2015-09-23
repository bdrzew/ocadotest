package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.OcadoExpectedConditions;

public class LoginPage extends AbstractPage {

    private static final String LOGIN_FORM_CSS = "#mainlogin ";

    @FindBy(css = LOGIN_FORM_CSS + "input[type='email']")
    private WebElement emailInput;
    @FindBy(css = LOGIN_FORM_CSS + "input[type='password']")
    private WebElement passwordInput;
    @FindBy(css = LOGIN_FORM_CSS + ".btn-register")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        emailInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage submitLoginForm(){
        submitButton.click();
        waitUntil(OcadoExpectedConditions.jQueryIsDone());
        waitForPageToLoad();
        waitUntil(OcadoExpectedConditions.documentIsReady());
        return new HomePage(driver);
    }
}
