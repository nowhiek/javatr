package by.javatr.task3.util;

import by.javatr.task3.entity.Square;

public class SquareOperation {

    private static double getAreaInscribedSquareInCircle(Square square){
        return Math.pow(square.getSideSquare(), 2) / 2;
    }

    public static double compareAreaTwoSquares(Square square){
        return (square.getSquareArea() / getAreaInscribedSquareInCircle(square));
    }
}
