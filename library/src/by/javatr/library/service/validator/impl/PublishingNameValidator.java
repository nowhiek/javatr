package by.javatr.library.service.validator.impl;

import by.javatr.library.entity.Publishing;
import by.javatr.library.service.validator.LibraryValidator;

public class PublishingNameValidator implements LibraryValidator <Publishing> {

    @Override
    public boolean validate(Publishing publishing) {
        return (publishing != null && publishing.getNamePublishing() != null && !publishing.getNamePublishing().isEmpty());
    }
}
