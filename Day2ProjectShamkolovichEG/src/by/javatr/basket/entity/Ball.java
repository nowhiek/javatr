package by.javatr.basket.entity;

public abstract class Ball {
    protected double weight;
    protected ColorEnum color;

    public Ball(double weight, ColorEnum color) {
        this.weight = weight;
        this.color = color;
    }

    public Ball() {
    }

    public double getBallWeight() {
        return weight;
    }

    public void setBallWeight(double weight) {
        this.weight = weight;
    }

    public ColorEnum getBallColor() {
        return color;
    }

    public void setBallColor(ColorEnum color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Ball tmp = (Ball)obj;

        if (weight != tmp.weight)
            return false;
        if (color == null){
            if (tmp.color != null)
                return false;
        }else if (!color.getTitle().equals(tmp.color.getTitle())){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "[TennisBall - " + weight + ", " + color + "]";
    }
}
