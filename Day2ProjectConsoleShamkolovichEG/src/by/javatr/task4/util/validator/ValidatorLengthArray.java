package by.javatr.task4.util.validator;

import by.javatr.task4.util.ArrayException;

public class ValidatorLengthArray {

    public void validate(String[] array) throws ArrayException {
        if (array.length == 0)
            throw new ArrayException("The method received an empty array.");
    }
}
