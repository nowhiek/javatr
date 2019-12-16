package by.javatr.array.runner;

import by.javatr.array.entity.Array;
import by.javatr.array.service.DataInput;

public class Main {

    public static void main(String[] args) {
        Array a = new Array(new int[]{123, 122, 974, 1001, 1234, -234, -323, 10, 9});

        try {
            //a.getArray()[0] = 111;
            System.out.println(a.toString());
            //a.insertSort();

            //int pos = a.binarySearch(5);

            //System.out.println(pos);
            //System.out.println(a.toString());
            Array b = new Array(DataInput.inputNumbersFromFile("file.txt"));
            b = a.getOnlyThreeNotSameDigitsInArray();
            System.out.println(b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
