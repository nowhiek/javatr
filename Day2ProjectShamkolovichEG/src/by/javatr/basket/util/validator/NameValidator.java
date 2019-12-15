package by.javatr.basket.util.validator;

public class NameValidator {

    public static boolean validate(String name) {
        return (name != null && !name.isEmpty());
    }
}
