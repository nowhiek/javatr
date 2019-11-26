package by.javatr.basket.util;

import by.javatr.basket.entity.Ball;

public interface BasketFeatures {

    void addBall(Ball ball);
    double getCommonWeightBallsInBasket();
    long getCountBlueBallsInBasket();
}
