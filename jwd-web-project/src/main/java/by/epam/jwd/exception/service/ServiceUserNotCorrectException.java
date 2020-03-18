package by.epam.jwd.exception.service;

public class ServiceUserNotCorrectException extends ServiceException {
	
	private static final long serialVersionUID = 24L;
    
	public ServiceUserNotCorrectException() {
    }

    public ServiceUserNotCorrectException(String message) {
        super(message);
    }

    public ServiceUserNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserNotCorrectException(Throwable cause) {
        super(cause);
    }
}
