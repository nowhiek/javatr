package by.javatr.basket.util;

public class InvalidBallSizeException extends Exception {
    public InvalidBallSizeException() {
    }

    public InvalidBallSizeException(String message) {
        super(message);
    }

    public InvalidBallSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBallSizeException(Throwable cause) {
        super(cause);
    }
}
