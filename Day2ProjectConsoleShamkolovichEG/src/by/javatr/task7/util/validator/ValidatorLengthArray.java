package by.javatr.task7.util.validator;

import by.javatr.task7.util.ArrayException;

public class ValidatorLengthArray {

    public void validate(String[] array) throws ArrayException {
        if (array.length != 3)
            throw new ArrayException("The method received illegal parameters.");
    }
}
