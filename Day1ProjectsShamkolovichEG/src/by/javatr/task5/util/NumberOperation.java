package by.javatr.task5.util;

public class NumberOperation {

    public static boolean isPerfectNumber(int number){
        int sum = 0;

        for(int i = 1; i < number; i++) {
            if(number % i == 0)
                sum += i;
        }

        return sum == number;
    }
}
