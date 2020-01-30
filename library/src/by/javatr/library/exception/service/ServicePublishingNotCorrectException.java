package by.javatr.library.exception.service;

public class ServicePublishingNotCorrectException extends ServiceException {
    public ServicePublishingNotCorrectException() {
    }

    public ServicePublishingNotCorrectException(String message) {
        super(message);
    }

    public ServicePublishingNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicePublishingNotCorrectException(Throwable cause) {
        super(cause);
    }
}
