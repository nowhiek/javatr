package by.javatr.jagged.service.validator;

public class JaggedLengthValidator {

    public boolean validate(int[][] jagged){
        return (jagged != null && jagged.length != 0);
    }
}
