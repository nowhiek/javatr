package by.javatr.basket.entity;

public class Basket {
    //has a - composition
    private Ball[] balls;
    private int capacity;

    public Ball getBall(int index) throws CloneNotSupportedException {
        Ball clone = balls[index].clone();

        return clone;
    }

    public void setBalls(Ball[] soccerBalls) {
        this.balls = soccerBalls;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Basket(int capacity) {
        this.capacity = capacity;
        this.balls = new Ball[capacity];
    }

    public Basket() {
        this.capacity = 5;
        this.balls = new Ball[capacity];
    }

    private boolean isBasketFull(Ball[] basket){
        for (int i = 0; i < basket.length; i++){
            if (basket[i] == null)
                return false;
        }

        return true;
    }

    public void addBall(Ball ball){
        if (!isBasketFull(balls)) {
            for (int i = 0; i < balls.length; i++) {
                if (balls[i] == null) {
                    balls[i] = ball;
                    break;
                }
            }
        }
    }

    public void removeBall(Ball ball){
        for (int i = 0; i < balls.length; i++){
            if (balls[i] != null && balls[i].equals(ball)) {
                balls[i] = null;
                break;
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Integer.valueOf(capacity).hashCode();

        for (int i = 0; i < balls.length; i++){
            result = prime * result + ((balls[i] == null) ? 0 : balls[i].hashCode());
        }

        return result;
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
            if (tmp.balls != null) {
                return false;
            }
        }else if (balls.length != tmp.balls.length) {
            return false;
        }else if (balls.length == tmp.balls.length) {
            for (int i = 0; i < balls.length; i++){
                if (Double.doubleToLongBits(balls[i].getBallWeight()) != Double.doubleToLongBits(tmp.balls[i].getBallWeight()) && balls[i].getBallColor().equals(tmp.balls[i].getBallColor())) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[" + getClass().getName() + " - \n");

        for (Ball ball: balls) {
            if (ball != null)
                sb.append("\t" + ball.toString() + "\n");
        }

        sb.append("]");

        return sb.toString();
    }
}
