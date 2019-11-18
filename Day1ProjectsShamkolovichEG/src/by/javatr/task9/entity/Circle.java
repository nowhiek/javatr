package by.javatr.task9.entity;

public class Circle {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(){
        this.radius = 0;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return  true;
        if (obj == null)
            return false;

        Circle tmp = (Circle)obj;

        if (radius != tmp.radius)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[Circle - radius : " + this.getRadius() + "]";
    }
}
