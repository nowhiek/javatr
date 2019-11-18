package by.javatr.task6.validate;

public class Validator {

    public boolean validate(int seconds) {
        return (seconds > 0 && seconds < 86_4000)? true : false;
    }
}
