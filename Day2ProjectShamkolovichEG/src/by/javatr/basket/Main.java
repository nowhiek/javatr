package by.javatr.basket;

import by.javatr.basket.entity.*;
import by.javatr.basket.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Basket basket = new Basket(6);

            SoccerBall soccerBall1 = new SoccerBall(21.0, ColorEnum.BLUE, 4);
            SoccerBall soccerBall2 = new SoccerBall(23.2, ColorEnum.GREEN, 3);
            Ball soccerBall3 = new SoccerBall(19.9, ColorEnum.LIGHT_BLUE, 4);
            Ball soccerBall4 = new SoccerBall(12.4, ColorEnum.ORANGE, 4);
            SoccerBall soccerBall5 = new SoccerBall(25.9, ColorEnum.GREEN, 4);

            TennisBall tennisBall = new TennisBall(3.1, ColorEnum.BLUE, "Premium");

            basket.addBall(soccerBall1);
            basket.addBall(soccerBall2);
            basket.addBall(soccerBall3);
            basket.addBall(soccerBall4);
            basket.addBall(soccerBall5);
            basket.addBall(tennisBall);

            basket.removeBall(soccerBall3);
            basket.addBall(soccerBall3);
            basket.removeBall(soccerBall3);

            basket.addBall(soccerBall4);


            BasketImpl impl = new BasketImpl(basket);

            double avg = impl.getCommonWeightBallsInBasket();
            long count = impl.getCountBlueBallsInBasket();

            System.out.println(basket.toString());

            System.out.println("Common weight: " + avg);
            System.out.println("Count blue balls: " + count);
        }catch (InvalidBallWeightException e){
            System.out.println("Oh, trouble with ball weight.\n" + e.getMessage());
        }catch (InvalidBallColorException e){
            System.out.println("Oh, trouble with ball color.\n" + e.getMessage());
        }catch (InvalidBallSizeException e){
            System.out.println("Oh, trouble with soccer ball size.\n" + e.getMessage());
        } catch (InvalidBallStatusException e) {
            System.out.println("Oh, trouble with tennis ball status.\n" + e.getMessage());
        } catch (CloneNotSupportedException e) {
            System.out.println("Oh, trouble with cloning.\n" + e.getMessage());
        }

        //In the catch block, we can do something to solve the problem.
    }
}
