package by.javatr.task10.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task10.util.NumberOperation;
import by.javatr.task10.util.validator.ValidatorRange;

public class Main {

    public static void main(String[] args) {
        int a = DataScanner.getIntValue();
        int b = DataScanner.getIntValue();
        int step = DataScanner.getIntValue();

        if (new ValidatorRange().validate(a, b)) {
            System.out.print(NumberOperation.getFunctionValueInRange(a, b, step));
        }else{
            //TODO throw new Exception
            System.out.print("Something's gone wrong");
        }
    }
}
