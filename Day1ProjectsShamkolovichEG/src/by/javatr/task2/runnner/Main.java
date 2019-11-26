package by.javatr.task2.runnner;

import by.javatr.scanner.DataScanner;
import by.javatr.task2.util.DateOperation;
import by.javatr.task2.util.validator.ValidatorDate;

public class Main {

    public static void main(String[] args) {

        int year = DataScanner.getIntValue();
        int month = DataScanner.getIntValue();

        if (new ValidatorDate().validate(year, month)){
            System.out.println(new DateOperation().getCountDaysInCurrentMonth(year, month));
        }else{
            //TODO throw new Exception
            System.out.print("Something's gone wrong");
        }
    }
}
