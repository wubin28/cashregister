package kata.testing.cashregister;

public class StubPurchase extends Purchase {
    private String purchaseAsString;

    public StubPurchase(String purchaseAsString) {
        super(null);
        this.purchaseAsString = purchaseAsString;
    }

    @Override
    public String asString() {
        return this.purchaseAsString;
    }
}
