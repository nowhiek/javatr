package by.javatr.task3.util;

import by.javatr.task3.entity.Square;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareOperationTest {

    @Test
    public void compareAreaTwoSquaresTest_Positive_Area() {
        double area = 36;

        Square square = new Square(area);

        double expected = 2;

        double actual = SquareOperation.compareAreaTwoSquares(square);

        assertEquals(expected, actual, 0.00001);
    }
}