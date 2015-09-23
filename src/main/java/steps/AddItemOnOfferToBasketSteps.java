package steps;

import assertion.TrolleyAssertions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.BuyAnyXXForXXPromo;
import page.BrowseShopPage;
import page.TrolleyPage;

public class AddItemOnOfferToBasketSteps extends AbstractSteps {

    private BuyAnyXXForXXPromo promo = new BuyAnyXXForXXPromo();

    @When("^'Buy any XX for XX' promo is available$")
    public void buyAnyXXForXXPromoIsAvailable() {
        new BrowseShopPage(driver)
            .findFirstBuyAnyXXForXXPromo(promo);
    }

    @And("^promotion conditions are met$")
    public void promotionConditionsAreMet() {
        new BrowseShopPage(driver)
            .addExactNumberOfItemsToCart(promo);
    }

    @Then("^total amount in basket is calculated correct$")
    public void totalAmountInBasketIsCalculatedCorrect() {
        new TrolleyPage(driver)
                .check(TrolleyAssertions.class)
                    .assertAmountInBasketIsCalculatedCorrectly(promo);

    }

}
