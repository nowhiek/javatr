package by.javatr.library.service.validator;

public class PasswordValidator {

    public static boolean validate(String password) {
        return (password != null && (password.length() > 5 && password.length() < 12));
    }
}
