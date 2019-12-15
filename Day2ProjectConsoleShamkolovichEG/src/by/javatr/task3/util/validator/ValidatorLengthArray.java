package by.javatr.task3.util.validator;

import by.javatr.task3.util.ArrayException;

public class ValidatorLengthArray {

    public void validate(String[] array) throws ArrayException {
        if (array.length < 2 || (Integer.parseInt(array[0]) != array.length - 1))
            throw new ArrayException("The method received illegal parameters.");
    }
}
