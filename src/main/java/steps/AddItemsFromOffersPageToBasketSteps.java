package steps;

import cucumber.api.java.en.Then;
import page.OffersPage;

public class AddItemsFromOffersPageToBasketSteps extends AbstractSteps {

    //I probably got it wrong - I couldn't find any specific user promo conditions in ocado
    //Just selected 3 top offers from offers page
    @Then("^add items met promo conditions to trolley$")
    public void addItemsMetPromoConditionsToTrolley() {
        new OffersPage(driver)
                .addFirstThreeOffersToCart();
    }

}
