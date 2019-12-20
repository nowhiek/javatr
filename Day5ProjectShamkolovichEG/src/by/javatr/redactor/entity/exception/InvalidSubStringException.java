package by.javatr.redactor.entity.exception;

public class InvalidSubStringException extends Exception {
    public InvalidSubStringException() {
    }

    public InvalidSubStringException(String message) {
        super(message);
    }

    public InvalidSubStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSubStringException(Throwable cause) {
        super(cause);
    }
}
