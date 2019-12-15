package by.javatr.task7.runner;

import by.javatr.task6.util.ArrayException;
import by.javatr.task6.util.validator.ValidatorLengthArray;
import by.javatr.task7.util.DateException;
import by.javatr.task7.util.DateOperation;
import by.javatr.task7.util.validator.ValidatorDateBorn;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        try {
            new ValidatorLengthArray().validate(args);

            int day = Integer.parseInt(args[0]);
            int month = Integer.parseInt(args[1]);
            int year = Integer.parseInt(args[2]);

            new ValidatorDateBorn().validate(day, month, year);

            Calendar calendar = new GregorianCalendar(year, month, day);


            System.out.println(DateOperation.getFullInformationAboutPerson(calendar));

            boolean flag = DateOperation.isPersonBirthday(day, month);

            if (flag){
                System.out.println("HAPPY BIRTHDAY!");
            }
        } catch (ArrayException e){
            e.printStackTrace();
        } catch (DateException e){
            e.printStackTrace();
        }
    }
}
