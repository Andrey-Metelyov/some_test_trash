import JUnitExamples.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {
    @Test
    @DisplayName("Add 1 and 2, result should be 3")
    void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        assertEquals(3,result);
    }

    @Test
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator calculator = new Calculator();
            calculator.divide(2, 0);
        });
    }
}