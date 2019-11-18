package by.javatr.task10.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task10.util.NumberOperation;

public class Main {

    public static void main(String[] args) {
        int a = DataScanner.getIntValue();
        int b = DataScanner.getIntValue();
        int step = DataScanner.getIntValue();

        System.out.print(NumberOperation.getFunctionValueInRange(a, b, step));
    }
}
