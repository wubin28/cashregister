package kata.testing.cashregister;

import org.junit.Test;

public class CashRegisterTest {

    @Test
    public void should_print_the_real_purchase() {
        Item[] items = new Item[] {
                new Item("Noodles", 10),
                new Item("Apples", 20)
        };
        Purchase purchase = new Purchase(items);
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);

        cashRegister.process(purchase);

        mockPrinter.verifyThatPrintWasCalled();
    }
}