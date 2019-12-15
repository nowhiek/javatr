package by.javatr.array.service;

import by.javatr.array.entity.Array;

public class StringOperation {

    public static Array getArrayFromLine(String line){
        String[] splitLine = line.split(RegexString.WHITESPACE);

        int[] intArray = new int[splitLine.length];

        for (int i = 0; i < splitLine.length; i++){
            intArray[i] = Integer.parseInt(splitLine[i]);
        }

        return new Array(intArray);
    }
}
