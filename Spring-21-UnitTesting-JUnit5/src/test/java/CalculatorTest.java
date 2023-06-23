import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCase1() {
        assertTrue(Calculator.add(2,4) == 6);
        assertFalse(Calculator.add(2,4) == 7);
    }

    @Test
    void testCase2() {
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);

    }

    @Test
    void testCase3() {
       //if both array has the same size, order, and content they are equal
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
       // assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2});
    }

    @Test
    void testCase4() {
      String n = null;
      String s = "my";
      assertNull(n);
      assertNotNull(s);
    }

    @Test
    void testCase5() {
        System.out.println("Test Case 5");
        Calculator c1 = new Calculator();//referring to a new object
        Calculator c2 = c1;//referring to the same object
        Calculator c3 = new Calculator();//referring to a new object
        assertSame(c1, c2);//referring the same object, so they are the same
        assertNotSame(c1, c3);//referring different objects, so they are not the same
    }

    @Test
    void add() {
        System.out.println("add");
        int actual = Calculator.add(2, 3);
        //compares expected vs actual otherwise throws the message
        assertEquals(5, actual, "It is not matching with expected value.");
    }
}
