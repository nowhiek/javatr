package by.javatr.basket.entity;

public class Basket {
    private Ball[] balls;

    public Ball[] getBalls() {
        return balls;
    }

    public void setBalls(Ball[] soccerBalls) {
        this.balls = soccerBalls;
    }

    public Basket(Ball[] soccerBalls) {
        this.balls = soccerBalls;
    }

    public Basket() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Basket tmp = (Basket)obj;

        if (balls == null){
            if (tmp.balls != null)
                return false;
        }else if (balls.length == tmp.balls.length) {
            for (int i = 0; i < balls.length; i++){
                if (balls[i].getBallWeight() != tmp.balls[i].getBallWeight() && balls[i].getBallColor().equals(tmp.balls[i].getBallColor())) {
                    return false;
                }
            }
        }else {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[Basket - \n");

        for (Ball ball: balls) {
            sb.append("\t" + "{Weight - " + ball.getBallWeight() + "} : " + ball.getBallColor() + "\n");
        }

        sb.append("]");

        return sb.toString();
    }
}
