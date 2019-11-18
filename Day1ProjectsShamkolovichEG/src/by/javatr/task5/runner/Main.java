package by.javatr.task5.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task5.util.NumberOperation;
import by.javatr.task5.validate.Validator;

public class Main {

    public static void main(String[] args) {
        int number = DataScanner.getIntValue();

        if (new Validator().validate(number)) {
            System.out.println(NumberOperation.isPerfectNumber(number));
        }else {
            //TODO throw new Exception
            System.out.print("Something's gone wrong");
        }
    }
}
