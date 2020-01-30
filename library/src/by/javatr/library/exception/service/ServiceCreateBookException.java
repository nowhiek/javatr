package by.javatr.library.exception.service;

public class ServiceCreateBookException extends ServiceException {
    public ServiceCreateBookException() {
    }

    public ServiceCreateBookException(String message) {
        super(message);
    }

    public ServiceCreateBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceCreateBookException(Throwable cause) {
        super(cause);
    }
}
