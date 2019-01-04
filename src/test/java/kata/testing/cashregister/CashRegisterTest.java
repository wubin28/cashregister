package kata.testing.cashregister;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

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

    @Test
    public void should_print_the_stub_purchase() {
        StubPurchase stubPurchase = new StubPurchase("purchase as string");
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);

        cashRegister.process(stubPurchase);

        mockPrinter.verifyThatPrintWasCalledWith("purchase as string");
    }

    @Test
    public void should_print_the_stub_purchase_using_mockito() {
        Purchase stubPurchase = mock(Purchase.class);
        when(stubPurchase.asString()).thenReturn("purchase as string");
        Printer mockPrinter = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(mockPrinter);

        cashRegister.process(stubPurchase);

        verify(mockPrinter, times(1)).print("purchase as string");
    }
}