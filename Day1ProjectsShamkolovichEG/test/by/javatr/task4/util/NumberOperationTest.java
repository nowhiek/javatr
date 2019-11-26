package by.javatr.task4.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOperationTest {

    @Test
    public void isMoreThanTwoEvenNumbersTest_Positive_Array() {
        int[] array = {1, 2, 3, 4};

        boolean expected = true;

        boolean actual = NumberOperation.isMoreThanTwoEvenNumbers(array);

        assertEquals(expected, actual);
    }

    @Test
    public void isMoreThanTwoEvenNumbersTest_Negative_Array() {
        int[] array = {-1, -2, 3, 4};

        boolean expected = true;

        boolean actual = NumberOperation.isMoreThanTwoEvenNumbers(array);

        assertEquals(expected, actual);
    }
}