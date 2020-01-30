package by.javatr.library.dao.factory;

import by.javatr.library.dao.impl.BookDAO;
import by.javatr.library.dao.impl.UserDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO bookDAOImpl = new BookDAO();
    private final UserDAO userDAOImpl = new UserDAO();

    private DAOFactory(){ }

    public static DAOFactory getInstance(){
        return instance;
    }

    public BookDAO getBookDAO(){
        return bookDAOImpl;
    }

    public UserDAO getUserDAO(){
        return userDAOImpl;
    }
}
