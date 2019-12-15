package by.javatr.task7.util.validator;

import by.javatr.task7.util.DateException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidatorDateBorn {

    public void validate(int day, int month, int year) throws DateException {
        if (!isValidateMonth(month) || !isValidateYear(year))
            throw new DateException("The method received illegal parameters.");

        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        int maxDayInCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (maxDayInCurrentMonth < day)
            throw new DateException("The method received illegal parameters.");
    }

    private boolean isValidateMonth(int month){
        return month > 0 && month < 13;
    }

    private boolean isValidateYear(int year){
        return year > 0;
    }
}
