package by.javatr.jagged.service.impl;

import by.javatr.jagged.service.ArrayOperationService;
import by.javatr.jagged.service.validator.ArrayLengthValidator;

public class ArrayOperation implements ArrayOperationService {

    @Override
    public int getMinimalValueInArray(int[] array) {
        if (!new ArrayLengthValidator().validate(array))
            return 0;

        int min = array[0];

        for (int i = 0; i < array.length; i++){
            if (min > array[i])
                min = array[i];
        }

        return min;
    }

    @Override
    public int getMaximalValueInArray(int[] array) {
        if (!new ArrayLengthValidator().validate(array))
            return 0;

        int max = array[0];

        for (int i = 0; i < array.length; i++){
            if (max < array[i])
                max = array[i];
        }

        return max;
    }

    @Override
    public int getSumValueInArray(int[] array) {
        if (!new ArrayLengthValidator().validate(array))
            return 0;

        int sum = 0;

        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum;
    }
}
