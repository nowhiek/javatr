package by.javatr.library.exception.service;

public class ServiceGetAllBooksException extends ServiceException {
    public ServiceGetAllBooksException() {
    }

    public ServiceGetAllBooksException(String message) {
        super(message);
    }

    public ServiceGetAllBooksException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceGetAllBooksException(Throwable cause) {
        super(cause);
    }
}
