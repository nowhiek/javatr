package by.javatr.array.service.validator;

public class ArrayLengthValidator {

    public boolean validate(Number[] array){
        return (array != null && array.length != 0);
    }
}
