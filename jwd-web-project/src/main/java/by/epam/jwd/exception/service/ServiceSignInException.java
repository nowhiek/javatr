package by.epam.jwd.exception.service;

public class ServiceSignInException extends ServiceException {
	
	private static final long serialVersionUID = 23L;
    
	public ServiceSignInException() {
    }

    public ServiceSignInException(String message) {
        super(message);
    }

    public ServiceSignInException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceSignInException(Throwable cause) {
        super(cause);
    }
}
