package by.javatr.array.generator;

import by.javatr.array.entity.Array;

public class ArrayGenerator {

    public Array generateIntegerNumbersInArray(int size, int min, int max) {
        Integer[] result = new Integer[size];

        for (int i = 0; i < result.length; i++){
            result[i] = randomValueInRange(min, max);
        }

        return new Array(result);
    }

    private int randomValueInRange(int min, int max) {
        if (min >= max){
            int tmp = max;
            max = min;
            min = tmp;
        }

        max -= min;

        return (int)(Math.random() * ++max) + min;
    }
}
