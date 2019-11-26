package by.javatr.task5.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOperationTest {

    @Test
    public void isPerfectNumberTest_Positive_Number() {
        int operand = 6;

        boolean expected = true;

        boolean actual = NumberOperation.isPerfectNumber(operand);

        assertEquals(expected, actual);
    }
}