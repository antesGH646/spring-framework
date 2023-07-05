import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void runningBefore() {
        System.out.println("Lines of code defined in @BeforeEach will run before each such as this test");
    }

    @AfterEach
    void runningAfter() {
        System.out.println("Lines of code defined in @AfterEach will run after each such as this test\n");
    }

    @BeforeAll
    static void runFirstSetUp() {
        System.out.println("Lines of code defined in @BeforeAll will run before all the tests\n");
    }

    @AfterAll
    static void runLastTearDown() {
        System.out.println("Lines of code defined in @AfterAll will run after all the tests");
    }
    @Test
    void testCase1() {
        System.out.println("Test 1");
        assertTrue(Calculator.add(2,4) == 6);
        assertFalse(Calculator.add(2,4) == 7);
    }

    @Test
    void testCase2() {
        System.out.println("Test 2");
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);

    }

    @Test
    void testCase3() {
        System.out.println("Test 3");
       //if both array has the same size, order, and content they are equal
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
       // assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2});
    }

    @Test
    void testCase4() {
        System.out.println("Test 4");
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
        System.out.println("add()");
        int actual = Calculator.add(2, 3);
        //compares expected vs actual otherwise throws the message
        assertEquals(5, actual, "It is not matching with expected value.");
    }

    /**
     * Any method that implements the execute() method of Executable interface
     * must throw exception, and add2() method is throwing an exception.
     * Assertion.assertThrows() accepts the expected exception type
     * and the method that is throwing the exception as a lambda function, why?
     * because Executable is defined as a functional interface.
     * NB. Consider the inheritance when calling methods
     */
    @Test
    void add2() {
        System.out.println("add2()");
        //IllegalArgumentException is the expected exception, so the test should pass
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(5,2));
        //NullPointerException is not the expected exception, so the test should fail
       // assertThrows(NullPointerException.class, () -> Calculator.add2(5,2));
    }
}
