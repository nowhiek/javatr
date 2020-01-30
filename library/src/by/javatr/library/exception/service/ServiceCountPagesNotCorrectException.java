package by.javatr.library.exception.service;

public class ServiceCountPagesNotCorrectException extends ServiceException {
    public ServiceCountPagesNotCorrectException() {
    }

    public ServiceCountPagesNotCorrectException(String message) {
        super(message);
    }

    public ServiceCountPagesNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceCountPagesNotCorrectException(Throwable cause) {
        super(cause);
    }
}
