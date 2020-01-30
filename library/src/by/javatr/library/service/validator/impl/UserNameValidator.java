package by.javatr.library.service.validator.impl;

import by.javatr.library.service.validator.LibraryValidator;

public class UserNameValidator implements LibraryValidator <String> {

    @Override
    public boolean validate(String name) {
        return (name != null && (name.length() > 4 && name.length() < 10));
    }
}
