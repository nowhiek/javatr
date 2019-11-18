package by.javatr.task1.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task1.util.NumberOperation;

public class Main {

    public static void main(String[] args) {
        int number = 0;

        number = DataScanner.getIntValue();

        System.out.println(NumberOperation.secondDegreeOfNumber(number));
    }
}
