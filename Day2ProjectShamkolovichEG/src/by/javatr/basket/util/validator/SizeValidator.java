package by.javatr.basket.util.validator;

public class SizeValidator {

    public static boolean validate(int size) {
        return (size > 0 && size < 6);
    }
}
