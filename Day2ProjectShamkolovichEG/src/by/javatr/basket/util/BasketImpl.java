package by.javatr.basket.util;

import by.javatr.basket.entity.Ball;
import by.javatr.basket.entity.Basket;
import by.javatr.basket.entity.ColorEnum;

import java.util.Arrays;

public class BasketImpl implements BasketFeatures{

    private Basket basket;

    public BasketImpl(Basket basket) {
        this.basket = basket;
    }

    public BasketImpl() {
    }

    @Override
    public void addBall(Ball ball) {
        Ball[] tmp = basket.getBalls();

        basket.setBalls(new Ball[tmp.length + 1]);

        for (int i = 0; i < tmp.length; i++){
            basket.getBalls()[i] = tmp[i];
        }

        basket.getBalls()[tmp.length] = ball;
    }

    @Override
    public double getCommonWeightBallsInBasket() {
        return Arrays.stream(basket.getBalls()).mapToDouble(b -> b.getBallWeight()).sum();
    }

    @Override
    public long getCountBlueBallsInBasket() {
        return Arrays.stream(basket.getBalls()).filter((b) -> b.getBallColor().equals(ColorEnum.BLUE)).count();
    }
}
