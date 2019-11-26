package by.javatr.basket.entity;

public class SoccerBall extends Ball {

    public SoccerBall(double weight, ColorEnum color) {
        super(weight, color);
    }

    public SoccerBall() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        SoccerBall tmp = (SoccerBall)obj;

        if (weight != tmp.weight)
            return false;
        if (color == null){
            if (tmp.color != null)
                return false;
        }else if (!color.equals(tmp.color))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[SoccerBall - " + weight + ", " + color + "]";
    }
}
