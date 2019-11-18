package by.javatr.task8.util;

public class ElementaryFunction {

    public static double getFunctionSystemValue(int x){
        return x >= 3 ? (Math.pow(-x, 2) + 3*x + 9) : (1/(Math.pow(x, 3) - 6));
    }
}
