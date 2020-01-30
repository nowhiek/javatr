package by.javatr.library.exception.service;

public class ServiceNameNotCorrectException extends ServiceException {
    public ServiceNameNotCorrectException() {
    }

    public ServiceNameNotCorrectException(String message) {
        super(message);
    }

    public ServiceNameNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceNameNotCorrectException(Throwable cause) {
        super(cause);
    }
}
