package by.javatr.task10.util;

public class NumberOperation {

    public static String getFunctionValueInRange(int a, int b, int step){
        StringBuilder sb = new StringBuilder();

        for (int i = a; i <= b; i += step){
            sb.append(i + " | " + Math.tan(i) + "\n");
        }

        return sb.toString();
    }
}
