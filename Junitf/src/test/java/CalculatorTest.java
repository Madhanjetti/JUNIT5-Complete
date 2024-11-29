import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Initialize the calculator before each test
    }

    @Test
    @DisplayName("Add two positive numbers")
    void testAdd() {
        assertEquals(15, calculator.add(10, 5), "10 + 5 should equal 15");
    }

    @Test
    @DisplayName("Subtract two numbers")
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5), "10 - 5 should equal 5");
    }

    @Test
    @DisplayName("Multiply two numbers")
    void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5), "10 * 5 should equal 50");
    }

    @Test
    @DisplayName("Divide two numbers")
    void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5), "10 / 5 should equal 2.0");
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Add multiple pairs of numbers")
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "3, -3, 0"
    })
    void testAddParameterized(int num1, int num2, int expected) {
        assertEquals(expected, calculator.add(num1, num2), () -> num1 + " + " + num2 + " should equal " + expected);
    }
}