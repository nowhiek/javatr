package by.javatr.task2.util;

import java.util.Calendar;

public class DateOperation {

    public static int getCountDaysInCurrentMonth(int year, int month){
        Calendar calendar = (Calendar) Calendar.getInstance().clone();
        calendar.set(year, month, 1);

        return  calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
