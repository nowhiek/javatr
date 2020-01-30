package by.javatr.library.exception.service;

public class ServiceRemoveUserException extends ServiceException {
    public ServiceRemoveUserException() {
    }

    public ServiceRemoveUserException(String message) {
        super(message);
    }

    public ServiceRemoveUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceRemoveUserException(Throwable cause) {
        super(cause);
    }
}
