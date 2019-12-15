package by.javatr.basket.util;

public class InvalidBallWeightException extends Exception {
    public InvalidBallWeightException() {
    }

    public InvalidBallWeightException(String message) {
        super(message);
    }

    public InvalidBallWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBallWeightException(Throwable cause) {
        super(cause);
    }
}
