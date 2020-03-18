package by.epam.jwd.dao.factory;

import by.epam.jwd.dao.UserDAO;
import by.epam.jwd.dao.impl.UserDAOImpl;

public class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDao = new UserDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDao;
    }
}
