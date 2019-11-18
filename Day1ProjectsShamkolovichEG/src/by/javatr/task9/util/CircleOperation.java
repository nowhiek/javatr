package by.javatr.task9.util;

import by.javatr.task9.entity.Circle;

public class CircleOperation {
    private Circle circle;

    public CircleOperation(Circle circle) {
        this.circle = circle;
    }

    public double getCircleArea(){
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }

    public double getCircleLength(){
        return 2 * Math.PI * circle.getRadius();
    }
}
