package by.epam.jwd.exception.service;

public class ServiceUserPasswordNotEqualsException extends ServiceException {
	
	private static final long serialVersionUID = 27L;
    
	public ServiceUserPasswordNotEqualsException() {
    }

    public ServiceUserPasswordNotEqualsException(String message) {
        super(message);
    }

    public ServiceUserPasswordNotEqualsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserPasswordNotEqualsException(Throwable cause) {
        super(cause);
    }
}