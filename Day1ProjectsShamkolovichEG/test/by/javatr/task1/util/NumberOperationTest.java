package by.javatr.task1.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOperationTest {

    @Test
    public void secondDegreeOfNumberTest_Positive_Number() {
        int operand = 12342;

        int expected = 4;

        int actual = NumberOperation.secondDegreeOfNumber(operand);

        assertEquals(expected, actual);
    }

    @Test
    public void secondDegreeOfNumberTest_Negative_Number() {
        int operand = -12342;

        int expected = 4;

        int actual = NumberOperation.secondDegreeOfNumber(operand);

        assertEquals(expected, actual);
    }

    @Test
    public void secondDegreeOfNumberTest_Zero() {
        int operand = 0;

        int expected = 0;

        int actual = NumberOperation.secondDegreeOfNumber(operand);

        assertEquals(expected, actual);
    }
}