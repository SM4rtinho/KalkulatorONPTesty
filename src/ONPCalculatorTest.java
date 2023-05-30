import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ONPCalculatorTest {
    private ONPCalculator calculator;

    @Before
    public void setUp() {
        calculator = new ONPCalculator();
    }

    @Test
    public void testSingleOperation() {
        String expression = "5 3 +";
        double expected = 8.0;

        double result = calculator.calculate(expression);

        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testMultipleOperations() {
        String expression = "2 3 + 4 *";
        double expected = 20.0;

        double result = calculator.calculate(expression);

        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testDivision() {
        String expression = "10 2 /";
        double expected = 5.0;

        double result = calculator.calculate(expression);

        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        String expression = "5 3 #";

        calculator.calculate(expression);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        String expression = "0 0 /";

       calculator.calculate(expression);
    }
}