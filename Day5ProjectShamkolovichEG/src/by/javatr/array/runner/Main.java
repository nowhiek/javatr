package by.javatr.array.runner;

import by.javatr.array.entity.Array;
import by.javatr.array.generator.ArrayGenerator;
import by.javatr.array.service.DataInput;

public class Main {

    public static void main(String[] args) {
        Array a = new Array(new int[]{5, 2, 4, 1, 1, 4, 7, 10, 9});

        try {
            a.getArray()[0] = 111;
            System.out.println(a.toString());
            //a.insertSort();

            int pos = a.binarySearch(5);

            System.out.println(pos);
            System.out.println(a.toString());
            Array b = DataInput.inputNumbersFromFile("file.txt");
            ArrayGenerator.generateNumbersInArray(b, 10, 50);
            System.out.println(b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
