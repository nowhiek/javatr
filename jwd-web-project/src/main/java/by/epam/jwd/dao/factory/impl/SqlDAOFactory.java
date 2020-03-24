package by.epam.jwd.dao.factory.impl;

import by.epam.jwd.dao.UserDAO;
import by.epam.jwd.dao.factory.DAOFactory;
import by.epam.jwd.dao.impl.UserDAOImpl;

public class SqlDAOFactory implements DAOFactory {
	
	private static final SqlDAOFactory instance = new SqlDAOFactory();
	private static final UserDAO userDAO = new UserDAOImpl();
	
	//other

	public static SqlDAOFactory getInstance() {
		return instance;
	}
	
	@Override
	public UserDAO getUserDAO() {
		return userDAO;
	}
}
