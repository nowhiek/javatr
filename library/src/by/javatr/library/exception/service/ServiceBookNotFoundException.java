package by.javatr.library.exception.service;

public class ServiceBookNotFoundException extends ServiceException {
    public ServiceBookNotFoundException() {
    }

    public ServiceBookNotFoundException(String message) {
        super(message);
    }

    public ServiceBookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceBookNotFoundException(Throwable cause) {
        super(cause);
    }
}
