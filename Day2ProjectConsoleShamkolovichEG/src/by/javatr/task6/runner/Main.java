package by.javatr.task6.runner;

import by.javatr.task6.util.validator.ValidatorDeadline;
import by.javatr.task6.util.validator.ValidatorLengthArray;
import by.javatr.task6.util.ArrayException;
import by.javatr.task6.util.DateOperation;
import by.javatr.task6.util.DeadlineException;

public class Main {

    public static void main(String[] args) {
        try{
            new ValidatorLengthArray().validate(args);

            String name = args[0];
            int deadline = Integer.parseInt(args[1]);

            new ValidatorDeadline().validate(deadline);

            String result = DateOperation.getFinalDate(deadline);

            System.out.println(name + " : " + result);
        }catch (ArrayException e){
            e.printStackTrace();
        }catch (DeadlineException e){
            e.printStackTrace();
        }
    }
}
