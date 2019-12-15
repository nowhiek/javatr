package by.javatr.task4.runner;

import by.javatr.task4.util.validator.ValidatorLengthArray;
import by.javatr.task4.entity.Password;
import by.javatr.task4.entity.User;
import by.javatr.task4.util.ArrayException;
import by.javatr.task4.util.UserService;

public class Main {

    public static void main(String[] args) {
        try {
            Password userPass = new Password("banana");
            User user = new User("Vova", userPass);

            new ValidatorLengthArray().validate(args);

            boolean flag = new UserService().isPasswordEquals(user, new Password(args[0]));

            if (flag){
                System.out.println("Passwords match.");
            }else {
                System.out.println("Passwords mismatch.");
            }
        }catch (ArrayException e){
            e.printStackTrace();
        }
    }
}
