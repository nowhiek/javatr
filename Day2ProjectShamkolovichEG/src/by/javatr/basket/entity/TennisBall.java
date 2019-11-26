package by.javatr.basket.entity;

public class TennisBall extends Ball{

    public TennisBall(double weight, ColorEnum color) {
        super(weight, color);
    }

    public TennisBall() {
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
        return "[TennisBall - " + weight + ", " + color + "]";
    }
}
