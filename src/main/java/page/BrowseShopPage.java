package page;

import model.BuyAnyXXForXXPromo;
import model.Promo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.OcadoExpectedConditions;

public class BrowseShopPage extends AbstractPage {

    private static final String ADD_BUTTON_CSS = ".productAdd";
    public static final String PRODUCT_COUNT_CSS = ".productCount";

    @FindBy(xpath = "//li[contains(@class, 'productDetails')][.//a[contains(@href,'buy-any')][contains(@href,'-for-')]]")
    private WebElement buyAnyXXForXXOfferItem;
    @FindBy(xpath = "//li[contains(@class, 'productDetails')][.//a[contains(@href,'half-price-was-')]]")
    private WebElement buyHalfPriceOfferItem;


    public BrowseShopPage(WebDriver driver) {
        super(driver);
    }

    public BrowseShopPage findFirstBuyAnyXXForXXPromo(Promo promo) {
        promo.setPromoItem(buyAnyXXForXXOfferItem);
        return this;
    }

    public BrowseShopPage findFirstBuyHalfPricePromo(Promo promo) {
        promo.setPromoItem(buyHalfPriceOfferItem);
        return this;
    }

    public BrowseShopPage addOneItemFromPromo(Promo promo) {
        promo.getSubElement(By.cssSelector(ADD_BUTTON_CSS)).click();
        waitUntil(ExpectedConditions.visibilityOf(
                promo.getSubElement(By.cssSelector(PRODUCT_COUNT_CSS))
        ));
        return this;
    }


    public BrowseShopPage addExactNumberOfItemsToCart(BuyAnyXXForXXPromo promo) {
        for(int i=0; i < promo.getAmount(); i++){
            promo.getSubElement(By.cssSelector(ADD_BUTTON_CSS)).click();
            waitUntil(OcadoExpectedConditions.jQueryIsDone());
        }
        return this;
    }
}
