package assertion;

import page.HomePage;

import static org.junit.Assert.assertTrue;

public class HomeAssertions extends AbstractAssertions<HomePage>{

    public HomeAssertions assertUserLoggedIn() {
        assertTrue("User not logged in: ", page.getMyShopTab().isDisplayed());
        return this;
    }
}
