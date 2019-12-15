package by.javatr.basket.entity;

import by.javatr.basket.util.InvalidBallColorException;
import by.javatr.basket.util.InvalidBallSizeException;
import by.javatr.basket.util.InvalidBallWeightException;
import by.javatr.basket.util.validator.SizeValidator;

public class SoccerBall extends Ball {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws InvalidBallSizeException {
        if (!SizeValidator.validate(size))
            throw new InvalidBallSizeException("The method received an invalid ball size.");

        this.size = size;
    }

    public SoccerBall(double weight, ColorEnum color, int size) throws InvalidBallSizeException, InvalidBallWeightException, InvalidBallColorException {
        super(weight, color);
        setSize(size);
    }

    public SoccerBall() throws InvalidBallSizeException {
        super();
        setSize(4);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Double.valueOf(this.weight).hashCode();
        result = prime * result + ((this.color == null) ? 0 : this.color.hashCode());
        result = prime * result + Integer.valueOf(size).hashCode();

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

        SoccerBall tmp = (SoccerBall)obj;

        if (this.size != tmp.size)
            return false;
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(tmp.weight))
            return false;
        if (this.color == null){
            if (tmp.color != null)
                return false;
        }else if (!this.color.equals(tmp.color))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + ": Weight - " + weight + ", " + color.toString() + ", Size - " + size + "]";
    }
}
