package by.javatr.library.service.validator.impl;

import by.javatr.library.service.validator.LibraryValidator;

public class PasswordValidator implements LibraryValidator <String> {

    @Override
    public boolean validate(String password) {
        return (password != null && (password.length() > 5 && password.length() < 12));
    }
}
