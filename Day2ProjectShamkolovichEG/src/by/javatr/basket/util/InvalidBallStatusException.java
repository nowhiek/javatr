package by.javatr.basket.util;

public class InvalidBallStatusException extends Exception {
    public InvalidBallStatusException() {
    }

    public InvalidBallStatusException(String message) {
        super(message);
    }

    public InvalidBallStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBallStatusException(Throwable cause) {
        super(cause);
    }
}
