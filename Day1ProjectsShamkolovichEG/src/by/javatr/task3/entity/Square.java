package by.javatr.task3.entity;

public class Square {
    private double squareArea;

    public double getSquareArea() {
        return squareArea;
    }

    public void setSquareArea(double squareArea) {
        this.squareArea = squareArea;
    }

    public Square(double squareArea) {
        this.squareArea = squareArea;
    }

    public Square(){}

    public double getSideSquare(){
        return Math.sqrt(squareArea);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Square tmp = (Square)obj;

        if (squareArea != tmp.squareArea)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[Square - side: " + getSideSquare() + ", area: " + getSquareArea() + "]";
    }
}
