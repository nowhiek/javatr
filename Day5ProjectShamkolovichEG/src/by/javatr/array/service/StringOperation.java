package by.javatr.array.service;

public class StringOperation {

    public static int[] getArrayFromLine(String line){
        String[] splitLine = line.split(RegexString.WHITESPACE);

        int[] intArray = new int[splitLine.length];

        for (int i = 0; i < splitLine.length; i++){
            intArray[i] = Integer.parseInt(splitLine[i]);
        }

        return intArray;
    }

    public static boolean isThreeNotSameDigits(String str){
        if (str.length() != 3)
            return false;

        for (char c : str.toCharArray()) {
            if (str.indexOf(c) != str.lastIndexOf(c))
                return false;
        }

        return true;
    }
}
