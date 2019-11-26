package by.javatr.task2.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateOperationTest {

    @Test
    public void getCountDaysInCurrentMonthTest_Positive_Date() {
        int month = 11, year = 2019;

        int expected = 31;

        int actual = DateOperation.getCountDaysInCurrentMonth(year, month);

        assertEquals(expected, actual);
    }
}