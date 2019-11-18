package by.javatr.task8.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task8.util.ElementaryFunction;

public class Main {

    public static void main(String[] args) {
        int number = DataScanner.getIntValue();

        System.out.println(ElementaryFunction.getFunctionSystemValue(number));
    }
}
