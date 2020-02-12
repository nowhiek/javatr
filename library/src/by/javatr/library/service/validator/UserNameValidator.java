package by.javatr.library.service.validator;

public class UserNameValidator {

    public static boolean validate(String name) {
        return (name != null && (name.length() > 4 && name.length() < 10));
    }
}
