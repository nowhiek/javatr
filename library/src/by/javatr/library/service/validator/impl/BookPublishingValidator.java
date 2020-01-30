package by.javatr.library.service.validator.impl;

import by.javatr.library.bean.Publishing;
import by.javatr.library.service.validator.LibraryValidator;

public class BookPublishingValidator implements LibraryValidator <Publishing> {

    @Override
    public boolean validate(Publishing publishing) {
        if (publishing == null)
            return true;

        return (publishing.getIdPublishing() > 0)
                && (publishing.getNamePublishing() != null && !publishing.getNamePublishing().isEmpty())
                && (publishing.getCountryPublishing() != null && !publishing.getNamePublishing().isEmpty());
    }
}
