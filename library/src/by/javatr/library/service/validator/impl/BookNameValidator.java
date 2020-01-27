package by.javatr.library.service.validator.impl;

import by.javatr.library.service.validator.LibraryValidator;

public class BookNameValidator implements LibraryValidator<String> {

    @Override
    public boolean validate(String field) {
        return (field != null && !field.isEmpty());
    }
}
