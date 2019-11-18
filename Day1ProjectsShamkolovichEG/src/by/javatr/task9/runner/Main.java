package by.javatr.task9.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task5.validate.Validator;
import by.javatr.task9.entity.Circle;
import by.javatr.task9.util.CircleOperation;

public class Main {

    public static void main(String[] args) {
        int radius = DataScanner.getIntValue();

        if (new Validator().validate(radius)) {
            Circle circle = new Circle(radius);

            CircleOperation operation = new CircleOperation(circle);

            System.out.print("Area: " + operation.getCircleArea() + ", length: " + operation.getCircleLength());
        }else{
            //TODO throw new Exception
            System.out.print("Something's gone wrong");
        }
    }
}
