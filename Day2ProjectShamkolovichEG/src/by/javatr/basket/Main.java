package by.javatr.basket;

import by.javatr.basket.entity.*;
import by.javatr.basket.util.BallException;
import by.javatr.basket.util.BasketImpl;
import by.javatr.basket.util.validator.WeightValidator;

public class Main {

    public static void main(String[] args) {
        SoccerBall soccerBall1 = new SoccerBall(21.0, ColorEnum.BLUE);
        SoccerBall soccerBall2 = new SoccerBall(23.2, ColorEnum.GREEN);
        Ball soccerBall3 = new SoccerBall(19.9, ColorEnum.LIGHT_BLUE);
        Ball soccerBall4 = new SoccerBall(12.4, ColorEnum.ORANGE);
        SoccerBall soccerBall5 = new SoccerBall(25.9, ColorEnum.GREEN);

        TennisBall tennisBall = new TennisBall(3.1, ColorEnum.BLUE);

        Ball[] balls = new Ball[] {soccerBall1, soccerBall2, soccerBall3, soccerBall4, soccerBall5, tennisBall};

        Basket basket = new Basket(balls);
        BasketImpl impl = new BasketImpl(basket);

        impl.addBall(soccerBall1);
        impl.addBall(soccerBall1);

        try {
            for(int i = 0; i < basket.getBalls().length; i++){
                WeightValidator.validate(basket.getBalls()[i]);
            }

            double avg = impl.getCommonWeightBallsInBasket();
            long count = impl.getCountBlueBallsInBasket();

            System.out.println(basket.toString());

            System.out.println("Common weight: " + avg);
            System.out.println("Count blue balls: " + count);
        }catch (BallException e){
            e.printStackTrace();
        }
    }
}
