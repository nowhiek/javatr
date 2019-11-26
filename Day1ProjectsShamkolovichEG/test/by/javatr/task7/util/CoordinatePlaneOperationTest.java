package by.javatr.task7.util;

import by.javatr.task7.entity.Point2D;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatePlaneOperationTest {

    @Test
    public void getNearestPointToOriginTest_Positive_Points() {
        Point2D firstPoint = new Point2D(2, 4);
        Point2D secondPoint = new Point2D(5, 7);

        Point2D expected = firstPoint;

        Point2D actual = new CoordinatePlaneOperation().getNearestPointToOrigin(firstPoint, secondPoint);

        assertEquals(expected, actual);
    }

    @Test
    public void getNearestPointToOriginTest_Negative_Points() {
        Point2D firstPoint = new Point2D(-2, -4);
        Point2D secondPoint = new Point2D(-5, -7);

        Point2D expected = firstPoint;

        Point2D actual = new CoordinatePlaneOperation().getNearestPointToOrigin(firstPoint, secondPoint);

        assertEquals(expected, actual);
    }
}