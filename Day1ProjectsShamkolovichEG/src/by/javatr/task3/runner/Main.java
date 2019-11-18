package by.javatr.task3.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task3.entity.Square;
import by.javatr.task3.util.SquareOperation;
import by.javatr.task3.validate.Validator;

public class Main {

    public static void main(String[] args) {
        double area = DataScanner.getIntValue();

        if (new Validator().validate(area)) {

            Square square = new Square(area);

            System.out.println(new SquareOperation().compareAreaTwoSquares(square));
        }else {
            //TODO throw new Exception
            System.out.print("Something's gone wrong");
        }
    }
}
