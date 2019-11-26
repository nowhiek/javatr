package by.javatr.task8.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElementaryFunctionTest {

    @Test
    public void getFunctionSystemValueTest_Number_More_Than_3() {
        int number = 5;

        double expected = 49.0;

        double actual = ElementaryFunction.getFunctionSystemValue(number);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getFunctionSystemValueTest_Number_Is_3() {
        int number = 3;

        double expected = 27.0;

        double actual = ElementaryFunction.getFunctionSystemValue(number);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getFunctionSystemValueTest_Number_Less_Than_3() {
        int number = 2;

        double expected = 0.5;

        double actual = ElementaryFunction.getFunctionSystemValue(number);

        assertEquals(expected, actual, 0.001);
    }
}