package model;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public abstract class Promo {
    private WebElement promoItem;

    public void setPromoItem(WebElement promoItem) {
        this.promoItem = promoItem;
        populateData();
    }

    public WebElement getSubElement(By by){
        return getPromoItem().findElement(by);
    }

    protected abstract void populateData();

}
