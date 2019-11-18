package by.javatr.task4.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task4.util.NumberOperation;

public class Main {

    public static void main(String[] args) {

            int a = DataScanner.getIntValue();
            int b = DataScanner.getIntValue();
            int c = DataScanner.getIntValue();
            int d = DataScanner.getIntValue();

            int[] array = new int[] {a,b,c,d};

            System.out.println(new NumberOperation().isMoreThanTwoEvenNumbers(array));

    }
}
