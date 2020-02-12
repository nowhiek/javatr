package by.javatr.library.service.validator;

import by.javatr.library.bean.Publishing;

public class BookPublishingValidator {

    public static boolean validate(Publishing publishing) {
        if (publishing == null)
            return true;

        return (publishing.getIdPublishing() > 0)
                && (publishing.getNamePublishing() != null && !publishing.getNamePublishing().isEmpty())
                && (publishing.getCountryPublishing() != null && !publishing.getNamePublishing().isEmpty());
    }
}
