package by.javatr.task2.runner;

import by.javatr.task2.util.ArrayException;
import by.javatr.task2.util.ArrayOperation;
import by.javatr.task2.util.validator.ValidatorLengthArray;

public class Main {

    public static void main(String[] args) {
        try{
            new ValidatorLengthArray().validate(args);

            String result = new ArrayOperation().getTextFromArray(args);

            System.out.println(result);
        }catch (ArrayException e){
            e.printStackTrace();
        }
    }
}
