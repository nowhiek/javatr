package by.javatr.task7.runner;

import by.javatr.scanner.DataScanner;
import by.javatr.task7.entity.Point2D;
import by.javatr.task7.util.CoordinatePlaneOperation;

public class Main {

    public static void main(String[] args) {
        int firstX = DataScanner.getIntValue();
        int firstY = DataScanner.getIntValue();

        int secondX = DataScanner.getIntValue();
        int secondY = DataScanner.getIntValue();

        Point2D firstP2 = new Point2D(firstX, firstY);
        Point2D secondP2 = new Point2D(secondX, secondY);

        System.out.println(new CoordinatePlaneOperation().getNearestPointToOrigin(firstP2, secondP2).toString());

    }
}
