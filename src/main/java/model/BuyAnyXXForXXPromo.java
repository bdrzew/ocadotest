package model;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class BuyAnyXXForXXPromo extends Promo {
    private static final String OFFER_BUTTON_CSS = ".onOffer";
    private int amount;
    private float price;

    protected void populateData() {
        WebElement buyAnyForOfferAnchor = getPromoItem().findElement(By.cssSelector(OFFER_BUTTON_CSS));
        Pattern p = Pattern.compile("^Buy any (.*) for (.*)$");
        Matcher m = p.matcher(buyAnyForOfferAnchor.getText());
        m.matches();
        amount = Integer.valueOf(m.group(1));
        price = Float.valueOf(m.group(2).substring(1));
    }

}
