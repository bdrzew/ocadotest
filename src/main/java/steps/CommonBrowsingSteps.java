package steps;

import assertion.HomeAssertions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import page.HomePage;

public class CommonBrowsingSteps extends AbstractSteps {

    @Given("^a customer on Browse Shop page$")
    public void customerOnBrowseShopPage() {
        new HomePage(driver, OCADO_URL)
                .openBrowseShopTab();
    }

    @Given("^a logged in customer$")
    public void loginCostumer() {
        new HomePage(driver, OCADO_URL)
                .openLoginForm()
                .enterEmail("test.auto.solutions@gmail.com")
                .enterPassword("test123")
                .submitLoginForm()
                .check(HomeAssertions.class)
                    .assertUserLoggedIn();
    }

    @When("^Offers page is displayed$")
    public void offersPageIsDisplayed() {
        new HomePage(driver)
                .openOffersTab();

    }

}
