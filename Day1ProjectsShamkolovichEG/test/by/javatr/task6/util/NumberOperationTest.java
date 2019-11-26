package by.javatr.task6.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOperationTest {

    @Test
    public void getCurrentTimeFromSecondsTest_Positive_Number() {
        int seconds = 7305;

        String expected = "2:1:45";

        String actual = NumberOperation.getCurrentTimeFromSeconds(seconds);

        assertEquals(expected, actual);
    }
}