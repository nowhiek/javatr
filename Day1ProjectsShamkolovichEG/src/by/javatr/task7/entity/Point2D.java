package by.javatr.task7.entity;

public class Point2D extends Point1D {
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point2D(int x, int y) {
        super(x);
        this.y = y;
    }

    public Point2D(){
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        Point2D tmp = (Point2D)obj;

        if (getX() != tmp.getX())
            return false;
        if (y != tmp.y)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " y: " + this.getY();
    }
}
