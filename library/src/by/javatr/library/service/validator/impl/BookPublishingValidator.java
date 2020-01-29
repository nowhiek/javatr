package by.javatr.library.service.validator.impl;

import by.javatr.library.entity.Publishing;
import by.javatr.library.service.validator.LibraryValidator;

public class BookPublishingValidator implements LibraryValidator <Publishing> {

    @Override
    public boolean validate(Publishing publishing) {
        if (publishing == null)
            return true;

        return (publishing.getNamePublishing() != null && !publishing.getNamePublishing().isEmpty());
    }
}
