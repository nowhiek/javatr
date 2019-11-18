package by.javatr.task1.util;

public class NumberOperation {

    private static int getLastDigitOfNumber(int number){
        return Math.abs(number) % 10;
    }

    public static int secondDegreeOfNumber(int operand){
        return (int)Math.pow(getLastDigitOfNumber(operand), 2);
    }
}
