package by.javatr.task6.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateOperation {

    private static int[] getParametersDate(int deadline){
        int[] params;

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, deadline);

        int date = calendar.getTime().getDate();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        int hour = calendar.getTime().getHours();
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        params = new int[]{date, month, year, hour, minutes, seconds};

        return params;
    }

    private static String getCurrentMonth(int[] params) {
        int param = params[1];

        switch (param) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return "Invalid month";
        }
    }

    public static String getFinalDate(int countDays){
        StringBuilder sb = new StringBuilder();

        int[] params = getParametersDate(countDays);

        String month = getCurrentMonth(params);

        sb.append(params[0] + " " + month + " " + params[2] + " " + params[3] + ":" + params[4] + ":" + params[5]);

        return sb.toString();
    }
}
