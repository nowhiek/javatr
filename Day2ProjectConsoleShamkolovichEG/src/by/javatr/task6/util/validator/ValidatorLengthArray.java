package by.javatr.task6.util.validator;

import by.javatr.task6.util.ArrayException;

public class ValidatorLengthArray {

    public void validate(String[] array) throws ArrayException {
        if (array.length != 2)
            throw new ArrayException("The method received illegal parameters.");
    }
}
