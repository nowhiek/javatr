package by.javatr.array.generator;

import by.javatr.array.entity.Array;
import by.javatr.array.service.InvalidRangeException;

public class ArrayGenerator {

    public static void generateNumbersInArray(Array array, int min, int max) throws InvalidRangeException {
        int[] result = new int[array.getArray().length];

        for (int i = 0; i < array.getArray().length; i++){
            result[i] = randomValueInRange(min, max);
        }

        array.setArray(result);
    }

    private static int randomValueInRange(int min, int max) throws InvalidRangeException {
        if (min >= max)
            throw new InvalidRangeException("Invalid values entered in the method.");

        max -= min;

        return (int)(Math.random() * ++max) + min;
    }
}
