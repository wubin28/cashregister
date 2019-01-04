package kata.testing.cashregister;

import static org.junit.Assert.assertTrue;

public class MockPrinter extends Printer {
    private boolean printWasCalled = false;

    public void verifyThatPrintWasCalledWith() {
        assertTrue("Print was not called. Expect print to be called at least once.", printWasCalled);
    }

    @Override
    public void print(String printThis) {
        printWasCalled = true;
    }
}
