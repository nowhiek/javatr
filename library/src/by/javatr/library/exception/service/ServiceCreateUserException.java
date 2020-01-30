package by.javatr.library.exception.service;

public class ServiceCreateUserException extends ServiceException {
    public ServiceCreateUserException() {
    }

    public ServiceCreateUserException(String message) {
        super(message);
    }

    public ServiceCreateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceCreateUserException(Throwable cause) {
        super(cause);
    }
}
