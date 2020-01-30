package by.javatr.library.exception.service;

public class ServiceBookNotCorrectException extends ServiceException {
    public ServiceBookNotCorrectException() {
    }

    public ServiceBookNotCorrectException(String message) {
        super(message);
    }

    public ServiceBookNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceBookNotCorrectException(Throwable cause) {
        super(cause);
    }
}
