package by.javatr.library.service.validator.impl;

import by.javatr.library.entity.User;
import by.javatr.library.service.validator.LibraryValidator;

public class UserValidator implements LibraryValidator <User> {

    @Override
    public boolean validate(User user) {
        return true;
    }
}
