package by.javatr.library.exception.service;

public class ServiceGetAllUsersException extends ServiceException {
    public ServiceGetAllUsersException() {
    }

    public ServiceGetAllUsersException(String message) {
        super(message);
    }

    public ServiceGetAllUsersException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceGetAllUsersException(Throwable cause) {
        super(cause);
    }
}
