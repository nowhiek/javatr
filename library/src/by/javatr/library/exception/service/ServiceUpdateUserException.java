package by.javatr.library.exception.service;

public class ServiceUpdateUserException extends ServiceException {
    public ServiceUpdateUserException() {
    }

    public ServiceUpdateUserException(String message) {
        super(message);
    }

    public ServiceUpdateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUpdateUserException(Throwable cause) {
        super(cause);
    }
}
