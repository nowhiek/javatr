package by.javatr.basket.util;

import by.javatr.basket.entity.Basket;
import by.javatr.basket.entity.ColorEnum;

public class BasketImpl implements BasketFeatures{

    private Basket basket;

    public BasketImpl(Basket basket) {
        this.basket = basket;
    }

    public BasketImpl() {
    }

    @Override
    public double getCommonWeightBallsInBasket() throws CloneNotSupportedException{
        double sumBallWeight = 0;

        for(int i = 0; i < basket.getCapacity(); i++){
            if (basket.getBall(i) != null)
                sumBallWeight += basket.getBall(i).getBallWeight();
        }

        return sumBallWeight;
    }

    @Override
    public long getCountBlueBallsInBasket() throws CloneNotSupportedException{
        int countBlueBalls = 0;

        for (int i = 0; i < basket.getCapacity(); i++){
            if (basket.getBall(i) != null && basket.getBall(i).getBallColor().equals(ColorEnum.BLUE))
                countBlueBalls++;
        }

        return countBlueBalls;
    }
}
