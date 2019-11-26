package by.javatr.task6.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task6.util.NumberOperation;
import by.javatr.task6.util.validator.ValidatorSecondRange;

public class Main {

    public static void main(String[] args) {
        int seconds = DataScanner.getIntValue();

        if (new ValidatorSecondRange().validate(seconds)) {
            System.out.println(NumberOperation.getCurrentTimeFromSeconds(seconds));
        }else {
            //TODO throw new Exception
            System.out.print("Something's gone wrong");
        }
    }
}
