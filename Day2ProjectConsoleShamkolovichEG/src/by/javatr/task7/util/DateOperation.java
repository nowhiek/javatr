package by.javatr.task7.util;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateOperation {

    private static int getPersonFullAge(int day, int month, int year){
        Calendar calendar = GregorianCalendar.getInstance();

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        int fullAge = currentYear - year;

        return ((month >= currentMonth) && (day >= currentDay)) ? fullAge : --fullAge;
    }

    public static boolean isPersonBirthday(int day, int month){
        Calendar calendar = GregorianCalendar.getInstance();

        return (calendar.get(Calendar.DAY_OF_MONTH) == day) && (calendar.get(Calendar.MONTH) + 1 == month);
    }

    private static int getWeekDay(Calendar calendar){
        return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) - 1;
    }

    private static String getNameWeekDay(int day){
        DateFormatSymbols dfs = new DateFormatSymbols();

        return dfs.getWeekdays()[day];
    }

    public static String getFullInformationAboutPerson(Calendar calendar){
        StringBuilder sb = new StringBuilder();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        sb.append("Person was born : " + getNameWeekDay(getWeekDay(calendar)) + " full age : " + getPersonFullAge(day, month, year));

        return sb.toString();
    }
}
