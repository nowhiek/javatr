package by.javatr.library.exception.service;

public class ServiceIdentifierNotCorrectException extends ServiceException {
    public ServiceIdentifierNotCorrectException() {
    }

    public ServiceIdentifierNotCorrectException(String message) {
        super(message);
    }

    public ServiceIdentifierNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceIdentifierNotCorrectException(Throwable cause) {
        super(cause);
    }
}
