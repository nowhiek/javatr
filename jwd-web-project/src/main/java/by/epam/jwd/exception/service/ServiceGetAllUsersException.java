package by.epam.jwd.exception.service;

public class ServiceGetAllUsersException extends ServiceException {
	
	private static final long serialVersionUID = 22L;
    
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
