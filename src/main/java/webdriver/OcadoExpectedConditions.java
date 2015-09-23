package webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class OcadoExpectedConditions {

    public static ExpectedCondition<Boolean> documentIsReady(){
        return driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }

    public static ExpectedCondition<Boolean> jQueryIsDone(){
        return driver -> {
            Long numberOfActiveCalls = (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active;");
            return numberOfActiveCalls.equals(new Long(0L));
        };
    }
}
