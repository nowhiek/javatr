package by.javatr.library.exception.service;

public class ServiceUserNotCorrectException extends ServiceException {
    public ServiceUserNotCorrectException() {
    }

    public ServiceUserNotCorrectException(String message) {
        super(message);
    }

    public ServiceUserNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserNotCorrectException(Throwable cause) {
        super(cause);
    }
}
