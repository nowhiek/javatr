package by.javatr.task9.util;

import by.javatr.task9.entity.Circle;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleOperationTest {

    @Test
    public void getCircleAreaTest_Positive_Radius() {
        double radius = 1;
        Circle circle = new Circle(radius);

        double expected = 3.14;

        double actual = new CircleOperation(circle).getCircleArea();

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getCircleLengthTest_Positive_Radius() {
        double radius = 1;
        Circle circle = new Circle(radius);

        double expected = 6.28;

        double actual = new CircleOperation(circle).getCircleLength();

        assertEquals(expected, actual, 0.01);
    }
}