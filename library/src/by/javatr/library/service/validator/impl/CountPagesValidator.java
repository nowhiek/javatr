package by.javatr.library.service.validator.impl;

import by.javatr.library.service.validator.LibraryValidator;

public class CountPagesValidator implements LibraryValidator<Integer> {

    @Override
    public boolean validate(Integer field) {
        return (field > 0);
    }
}
