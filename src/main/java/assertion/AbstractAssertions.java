package assertion;

import page.AbstractPage;

public abstract class AbstractAssertions<T extends AbstractPage> {

    protected T page;

    public T endAssertion() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }
}
