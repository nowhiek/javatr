package by.javatr.task2.util.validator;

public class ValidatorDate {

    public boolean validate(int year, int month) {
        return year > 0 && (month >= 0 && month <= 11);
    }
}
