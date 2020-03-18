package by.epam.jwd.exception.service;

public class ServiceLoginNotCorrectException extends ServiceException {

	private static final long serialVersionUID = 25L;
    
	public ServiceLoginNotCorrectException() {
    }

    public ServiceLoginNotCorrectException(String message) {
        super(message);
    }

    public ServiceLoginNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceLoginNotCorrectException(Throwable cause) {
        super(cause);
    }
	
}
