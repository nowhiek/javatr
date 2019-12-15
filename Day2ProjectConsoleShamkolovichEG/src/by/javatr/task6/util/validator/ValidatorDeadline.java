package by.javatr.task6.util.validator;

import by.javatr.task6.util.DeadlineException;

public class ValidatorDeadline {

    public void validate(int deadline) throws DeadlineException {
        if (deadline < 1)
            throw new DeadlineException("The method received illegal parameter.");
    }
}
