package by.javatr.task5.util;

import java.util.Arrays;

public class ArrayCalculator {

    public static int getSumOfAllNumbers(int[] array){
        return Arrays.stream(array).sum();
    }

    public static int getMultiplicationOfAllNumbers(int[] array){
        int result = 1;

        for (int i = 0; i < array.length; i++){
            result *= array[i];
        }

        return result;
    }
}
