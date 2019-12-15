package by.javatr.task2.util;

public class ArrayOperation {

    public String getTextFromArray(String[] array){
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--){
            sb.append(array[i] + "\t");
        }

        return sb.toString();
    }
}
