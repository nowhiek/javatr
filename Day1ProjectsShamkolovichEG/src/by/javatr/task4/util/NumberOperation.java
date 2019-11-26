package by.javatr.task4.util;

public class NumberOperation {

    private static int getCountEvenNumbers(int[] numbers) {
        int countEvenNumbers = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)
                countEvenNumbers++;
        }

        return countEvenNumbers;
    }

    public static boolean isMoreThanTwoEvenNumbers(int[] numbers) {
        return getCountEvenNumbers(numbers) >= 2;
    }
}
