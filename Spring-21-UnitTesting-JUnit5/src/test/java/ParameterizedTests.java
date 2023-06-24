import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTests {

    @ParameterizedTest//runs the test and loops through the given test data
    //provides a source from a single parameter per test
    @ValueSource( strings = {"Java","JavaScript", "TypeScript"})//can use all primitive types and string literals
    void testCase1(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource( ints = {2,6,8})
    void testCase2(int num) {
        Assertions.assertEquals(0, num % 2 );
    }

    @ParameterizedTest
    @ValueSource( strings = {"Java","JavaScript", "TypeScript"})
    @EmptySource//will make it fail b/c the argument is not empty
    void testCase3(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource( strings = {"Java","JavaScript", "TypeScript"})
    @NullSource//will make it fail b/c the argument is not empty
    void testCase4(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource( strings = {"Java","JavaScript", "TypeScript"})
    @NullAndEmptySource//combines both empty and null sources
    void testCase5(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider") //accepts the method that returns the sources
    void testCase6(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    static String[] stringProvider() {
        return new String[] {"Java","JavaScript", "TypeScript"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30", "20,30,50", "52,4,78"})//strings separated by commas, hard code sources for less test data
     void testCase7(int num1, int num2, int result) {
         Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    //if you have big test data, use a file source, skip the 1st line
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase8(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

}
