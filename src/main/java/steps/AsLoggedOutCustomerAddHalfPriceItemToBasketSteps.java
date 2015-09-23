package steps;

import assertion.TrolleyAssertions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.HalfPricePromo;
import page.BrowseShopPage;
import page.TrolleyPage;

public class AsLoggedOutCustomerAddHalfPriceItemToBasketSteps extends AbstractSteps {

    HalfPricePromo promo = new HalfPricePromo();

    @When("^customer add item in Half price promo to basket$")
    public void customerAddItemInHalfPricePromoToBasket() {
        new BrowseShopPage(driver)
                .findFirstBuyHalfPricePromo(promo)
                .addOneItemFromPromo(promo);
    }

    @Then("^saving field is updated$")
    public void savingFieldIsUpdated() {
        new TrolleyPage(driver)
                .check(TrolleyAssertions.class)
                    .assertSavingFieldIsUpdated();
    }

    @And("^contains correct savings value$")
    public void containsCorrectSavingsValue() {
        new TrolleyPage(driver)
                .check(TrolleyAssertions.class)
                    .assertSavingFieldContainsCorrectValue(promo);
    }
}
