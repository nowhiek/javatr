package by.javatr.task2.validate;

public class Validator {

    public boolean validate(int year, int month) {
        return (year > 0 && (month >= 0 && month <= 11)) ? true : false;
    }
}
