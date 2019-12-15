package by.javatr.task3.runner;

import by.javatr.task3.util.ArrayException;
import by.javatr.task3.util.ArrayOperation;
import by.javatr.task3.util.validator.ValidatorLengthArray;

public class Main {

    public static void main(String[] args) {
        try{
            new ValidatorLengthArray().validate(args);

            int[] array = new int[args.length];

            ArrayOperation.randomFillArray(array);

            for (int value : array) {
                System.out.print(value + "\n");
            }

            for (int value : array) {
                System.out.print(value + "\t");
            }
        }catch (ArrayException e){
            e.printStackTrace();
        }
    }
}
