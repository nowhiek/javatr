package by.javatr.array.runner;

import by.javatr.array.entity.Array;
import by.javatr.array.entity.exception.InvalidArrayException;
import by.javatr.array.generator.ArrayGenerator;


public class Main {

    public static void main(String[] args) {
        Array a = new Array(new Integer[]{1, 4, 2, 4, 5, 6, 7, 8, 9});

        try {

            a.mergeSort(0, a.getArrayLength() - 1);

            System.out.println(a.binarySearch(5));

            Array b = a.getOnlyPrimeNumbersInArray();
            System.out.println(a.toString());


            Array c = new ArrayGenerator().generateIntegerNumbersInArray(5, 0, 10);
            System.out.println(c.toString());

            Array d = a.getOnlyPrimeNumbersInArray();
            System.out.println(d.toString());
        } catch (InvalidArrayException e) {
            e.printStackTrace(); //Only for programmer
        }
    }
}
