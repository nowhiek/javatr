package by.javatr.basket.util;

public class BallException extends Exception {
    public BallException() {
    }

    public BallException(String message) {
        super(message);
    }

    public BallException(Throwable cause) {
        super(cause);
    }

    public BallException(String message, Throwable cause) {
        super(message, cause);
    }
}
