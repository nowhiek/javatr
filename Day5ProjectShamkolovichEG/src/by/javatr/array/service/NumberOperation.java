package by.javatr.array.service;

public class NumberOperation {

    public static boolean isPrimeNumber(int number){
        if (number < 2)
            return false;

        double tmp = Math.sqrt(number);

        for (int i = 2; i <= tmp; i++){
            if (number % i == 0){
                return false;
            }
        }

        return true;
    }

    public static boolean isFibonachiNumber(int number){
        if (number < 0)
            return false;

        int a = 0;
        int b = 1;

        int tmp;

        while (true){
            tmp = a + b;

            if (tmp > number)
                return false;

            if (tmp == number)
                return true;

            a = b;
            b = tmp;
        }
    }
}
