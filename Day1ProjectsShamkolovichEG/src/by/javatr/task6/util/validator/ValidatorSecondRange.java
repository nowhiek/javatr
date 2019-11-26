package by.javatr.task6.util.validator;

public class ValidatorSecondRange {

    public boolean validate(int seconds) {
        return seconds > 0 && seconds < 86_4000;
    }
}
