import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCase1() {
        fail("Not implemented yet");
    }

    @Test
    void testCase2() {
        fail("Not implemented yet");
    }

    @Test
    void testCase3() {
        fail("Not implemented yet");

    }

    @Test
    void testCase4() {

    }

    @Test
    void testCase5() {

    }

    @Test
    void add() {
        System.out.println("add");
        int actual = Calculator.add(2, 3);
        //compares expected vs actual otherwise throws the message
        assertEquals(5, actual, "It is not matching with expected value.");
    }
}
