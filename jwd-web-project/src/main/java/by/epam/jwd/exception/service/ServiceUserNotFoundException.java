package by.epam.jwd.exception.service;

public class ServiceUserNotFoundException extends ServiceException {
	
	private static final long serialVersionUID = 26L;
    
	public ServiceUserNotFoundException() {
    }

    public ServiceUserNotFoundException(String message) {
        super(message);
    }

    public ServiceUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserNotFoundException(Throwable cause) {
        super(cause);
    }
}
