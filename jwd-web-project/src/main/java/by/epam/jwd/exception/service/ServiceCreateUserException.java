package by.epam.jwd.exception.service;

public class ServiceCreateUserException extends ServiceException{

	private static final long serialVersionUID = 21L;
    
	public ServiceCreateUserException() {
    }

    public ServiceCreateUserException(String message) {
        super(message);
    }

    public ServiceCreateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceCreateUserException(Throwable cause) {
        super(cause);
    }
}
