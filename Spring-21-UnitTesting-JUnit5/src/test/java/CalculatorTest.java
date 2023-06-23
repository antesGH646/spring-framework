import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        System.out.println("add");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "It is not matching with expected value.");
    }
}
