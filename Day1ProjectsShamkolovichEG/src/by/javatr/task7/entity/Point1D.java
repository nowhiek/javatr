package by.javatr.task7.entity;

public class Point1D {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Point1D(int x) {
        this.x = x;
    }

    public Point1D(){
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        Point1D tmp = (Point1D)obj;

        if (x != tmp.x)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Point - x : " + this.getX();
    }
}
