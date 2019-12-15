package by.javatr.task6.util;

public class DeadlineException extends Exception {
    public DeadlineException() {
    }

    public DeadlineException(String message) {
        super(message);
    }

    public DeadlineException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeadlineException(Throwable cause) {
        super(cause);
    }
}
