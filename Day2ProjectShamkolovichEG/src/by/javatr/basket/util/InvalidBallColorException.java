package by.javatr.basket.util;

public class InvalidBallColorException extends Exception {
    public InvalidBallColorException() {
    }

    public InvalidBallColorException(String message) {
        super(message);
    }

    public InvalidBallColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBallColorException(Throwable cause) {
        super(cause);
    }
}
