package model;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class HalfPricePromo extends Promo {
    private static final String NOW_PRICE_CSS = ".nowPrice";
    private float savings;

    protected void populateData() {
        savings = Float.valueOf(
                getPromoItem()
                .findElement(By.cssSelector(NOW_PRICE_CSS))
                .getText()
                .substring(1)
        );
    }

}
