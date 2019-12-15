package by.javatr.basket.entity;

import by.javatr.basket.util.InvalidBallColorException;
import by.javatr.basket.util.InvalidBallStatusException;
import by.javatr.basket.util.InvalidBallWeightException;
import by.javatr.basket.util.validator.NameValidator;

public class TennisBall extends Ball{
    private String statusBall;

    public String getStatusBall() {
        return statusBall;
    }

    public void setStatusBall(String statusBall) throws InvalidBallStatusException {
        if (!NameValidator.validate(statusBall))
            throw new InvalidBallStatusException("The method received an invalid status ball.");

        this.statusBall = statusBall;
    }

    public TennisBall(double weight, ColorEnum color, String statusBall) throws InvalidBallStatusException, InvalidBallWeightException, InvalidBallColorException {
        super(weight, color);
        setStatusBall(statusBall);
    }

    public TennisBall() throws InvalidBallStatusException {
        super();
        setStatusBall("normal");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Double.valueOf(this.weight).hashCode();
        result = prime * result + ((this.color == null) ? 0 : this.color.hashCode());
        result = prime * result + ((statusBall == null) ? 0 : statusBall.hashCode());

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

        TennisBall tmp = (TennisBall)obj;

        if (statusBall == null){
            if (tmp.statusBall != null)
                return false;
        }else if (!statusBall.equals(tmp.statusBall)){
            return false;
        }
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
        return "[" + getClass().getName() + ": Weight - " + weight + ", " + color.toString() + ", Status - " + statusBall + "]";
    }
}
