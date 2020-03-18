package by.epam.jwd.service;

import by.epam.jwd.bean.User;
import by.epam.jwd.exception.service.ServiceException;

public interface UserService {
	boolean create(User user) throws ServiceException;
	void signIn(String login, String password) throws ServiceException;
	User findUserByLogin(String login) throws ServiceException;
}
