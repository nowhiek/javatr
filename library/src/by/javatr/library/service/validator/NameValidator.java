package by.javatr.library.service.validator;

public class NameValidator {

    public static boolean validate(String field) {
        return (field != null && !field.isEmpty());
    }
}
