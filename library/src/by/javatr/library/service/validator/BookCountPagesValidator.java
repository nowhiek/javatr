package by.javatr.library.service.validator;

public class BookCountPagesValidator {

    public static boolean validate(Integer field) {
        return (field > 0);
    }
}
