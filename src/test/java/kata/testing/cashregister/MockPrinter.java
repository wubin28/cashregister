package kata.testing.cashregister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MockPrinter extends Printer {
    private boolean printWasCalled = false;
    private String printWasCalledWith = "";

    public void verifyThatPrintWasCalled() {
        assertTrue("Print was not called. Expect print to be called at least once.", printWasCalled);
    }

    @Override
    public void print(String printThis) {
        printWasCalled = true;
        printWasCalledWith = printThis;
    }

    public void verifyThatPrintWasCalledWith(String purchase_as_string) {
        verifyThatPrintWasCalled();
        assertEquals("expected print to be called with '" + purchase_as_string + "', but was called with '" + printWasCalledWith + "'",
                purchase_as_string, printWasCalledWith);
    }
}
