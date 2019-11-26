package by.javatr.task10.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOperationTest {

    @Test
    public void getFunctionValueInRangeTest_Positive_Range() {
        int a = 1;
        int b = 10;
        int step = 1;

        String expected = "1 | 1.5574077246549023\n" +
                "2 | -2.185039863261519\n" +
                "3 | -0.1425465430742778\n" +
                "4 | 1.1578212823495775\n" +
                "5 | -3.380515006246586\n" +
                "6 | -0.29100619138474915\n" +
                "7 | 0.8714479827243188\n" +
                "8 | -6.799711455220379\n" +
                "9 | -0.45231565944180985\n" +
                "10 | 0.6483608274590866\n";

        String actual = NumberOperation.getFunctionValueInRange(a, b, step);

        assertEquals(expected, actual);
    }
}