package by.javatr.task5.util;

public class ArgumentConventor {

    public static int[] parseStringArrayToInteger(String[] array){
        int[] intArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
            intArray[i] = Integer.parseInt(array[i]);
        }

        return intArray;
    }
}
