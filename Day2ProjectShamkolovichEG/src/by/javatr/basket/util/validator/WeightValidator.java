package by.javatr.basket.util.validator;

import by.javatr.basket.entity.Ball;
import by.javatr.basket.util.BallException;

public class WeightValidator {

    public static void validate(Ball ball) throws BallException {
        if (ball.getBallWeight() < 0)
            throw new BallException("You entered an invalid ball weight.");
    }
}
