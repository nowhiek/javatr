package by.javatr.basket.entity;

import by.javatr.basket.util.InvalidBallColorException;
import by.javatr.basket.util.InvalidBallWeightException;
import by.javatr.basket.util.validator.ColorValidator;
import by.javatr.basket.util.validator.WeightValidator;

public abstract class Ball implements Cloneable{
    protected double weight;
    protected ColorEnum color;

    public double getBallWeight() {
        return weight;
    }

    public void setBallWeight(double weight) throws InvalidBallWeightException {
        if (!WeightValidator.validate(weight))
            throw new InvalidBallWeightException("The method received an invalid ball weight.");

        this.weight = weight;
    }

    public ColorEnum getBallColor() {
        return color;
    }

    public void setBallColor(ColorEnum color) throws InvalidBallColorException {
        if (!ColorValidator.validate(color))
            throw new InvalidBallColorException("The method received an invalid ball color.");

        this.color = color;
    }

    protected Ball(double weight, ColorEnum color) throws InvalidBallWeightException, InvalidBallColorException{
        setBallWeight(weight);
        setBallColor(color);
    }

    protected Ball() {
        this.weight = 1.0;
        this.color = ColorEnum.RED;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Double.valueOf(weight).hashCode();
        result = prime * result + ((color == null) ? 0 : color.hashCode());

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

        Ball tmp = (Ball)obj;

        if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(tmp.weight))
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
        return "[" + getClass().getName() + " weight - " + weight + ", color - " + color + "]";
    }

    @Override
    public Ball clone() throws CloneNotSupportedException {
        return (Ball) super.clone();
    }
}
