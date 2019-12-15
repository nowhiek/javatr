package by.javatr.task3.util;

import java.util.Random;

public class ArrayOperation {

    public static void randomFillArray(int[] array){
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(10);
        }
    }
}
