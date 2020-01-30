package by.javatr.library.exception.dao;

public class DAOFileParseException extends DAOException {
    public DAOFileParseException() {
    }

    public DAOFileParseException(String message) {
        super(message);
    }

    public DAOFileParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOFileParseException(Throwable cause) {
        super(cause);
    }
}
