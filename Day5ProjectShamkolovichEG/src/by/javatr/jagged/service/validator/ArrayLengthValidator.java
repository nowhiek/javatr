package by.javatr.jagged.service.validator;

public class ArrayLengthValidator {

    public boolean validate(int[] jagged){
        return (jagged != null && jagged.length != 0);
    }
}
