package by.javatr.task5.runner;

import by.javatr.task5.util.ArgumentConventor;
import by.javatr.task5.util.ArrayCalculator;
import by.javatr.task5.util.validator.ValidatorLengthArray;
import by.javatr.task5.util.ArrayException;

public class Main {

    public static void main(String[] args) {
	    try {
	        new ValidatorLengthArray().validate(args);

	        int[] array = ArgumentConventor.parseStringArrayToInteger(args);

	        int sum = ArrayCalculator.getSumOfAllNumbers(array);
	        int mul = ArrayCalculator.getMultiplicationOfAllNumbers(array);

	        System.out.println("Sum : " + sum + ", mul : " + mul);
        }catch (ArrayException e){
	        e.printStackTrace();
        }
    }
}
