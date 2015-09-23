package assertion;

import model.BuyAnyXXForXXPromo;
import model.HalfPricePromo;
import page.TrolleyPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TrolleyAssertions extends AbstractAssertions<TrolleyPage> {
    public TrolleyAssertions assertAmountInBasketIsCalculatedCorrectly(BuyAnyXXForXXPromo promo) {
        assertEquals("Trolley summary value not as expected: ",
                String.format("%.2f", promo.getPrice()),
                page.getBasketSummaryTotal().getText().substring(1));
        return this;
    }

    public TrolleyAssertions assertSavingFieldIsUpdated() {
        assertFalse("Trolley savings summary was not updated from £0.00.",
                "0.00".equals(page.getBasketSummarySavings().getText().substring(1)));
        return this;
    }



    public TrolleyAssertions assertSavingFieldContainsCorrectValue(HalfPricePromo promo) {
        assertEquals("Trolley saving summary value not as expected: ",
                String.format("%.2f", promo.getSavings()),
                page.getBasketSummarySavings().getText().substring(1));
        return this;
    }
}
