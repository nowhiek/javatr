package by.javatr.task7.util;

import by.javatr.task7.entity.Point2D;

public class CoordinatePlaneOperation {

    public Point2D getNearestPointToOrigin(Point2D firstPoint, Point2D secondPoint){
        double distanceFirstPoint = getDistanceToOrigin(firstPoint);
        double distanceSecondPoint = getDistanceToOrigin(secondPoint);

        return distanceFirstPoint > distanceSecondPoint ? secondPoint : firstPoint;
    }

    private double getDistanceToOrigin(Point2D point){
        return Math.sqrt(Math.pow(0 - point.getX(), 2) + Math.pow(0 - point.getY(), 2));
    }
}
