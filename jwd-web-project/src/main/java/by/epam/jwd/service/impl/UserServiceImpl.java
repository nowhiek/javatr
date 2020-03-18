package by.epam.jwd.service.impl;

import java.util.List;

import by.epam.jwd.bean.User;
import by.epam.jwd.dao.UserDAO;
import by.epam.jwd.dao.factory.DAOFactory;
import by.epam.jwd.exception.dao.DAOException;
import by.epam.jwd.exception.service.ServiceCreateUserException;
import by.epam.jwd.exception.service.ServiceException;
import by.epam.jwd.exception.service.ServiceGetAllUsersException;
import by.epam.jwd.exception.service.ServiceSignInException;
import by.epam.jwd.exception.service.ServiceUserNotFoundException;
import by.epam.jwd.exception.service.ServiceUserPasswordNotEqualsException;
import by.epam.jwd.service.UserService;
import by.epam.jwd.service.validator.CreateUserValidator;
import by.epam.jwd.service.validator.StringValidator;

public class UserServiceImpl implements UserService {

	private DAOFactory daoFactory = DAOFactory.getInstance();
	private UserDAO userDAO = daoFactory.getUserDAO();
	
	@Override
	public boolean create(User user) throws ServiceException {
		try {
			//Not correct.
			if (!CreateUserValidator.validate(user)) {
				return false;
			}
			
			if (isUserExist(user)) {
				throw new ServiceCreateUserException("This user was already exist.");
			}
			
			userDAO.create(user);
		} catch (DAOException e) {
			throw new ServiceCreateUserException("I can't create the user. DAOException.", e);
		}
		
		return true;
	}

	@Override
	public void signIn(String login, String password) throws ServiceException {
		User tmp = findUserByLogin(login);
		
		if (!StringValidator.validate(password)) { 
			throw new ServiceSignInException("You entered empty password.");
		}
		
		if (tmp == null) {
			throw new ServiceUserNotFoundException("This user not found.");
		}
		
		if (!tmp.getUserPassword().equals(password)) {
			throw new ServiceUserPasswordNotEqualsException("You entered not equals password");
		}
	}
	
	@Override
	public User findUserByLogin(String login) throws ServiceException {
		if (!StringValidator.validate(login)) {
			throw new ServiceSignInException("You entered empty login.");
		}
		
		List<User> users = null;
        User user = null;
		
        try {
        	users = userDAO.getAll();

            for (User usr : users) {
                if (usr.getUserName().equals(login)) {
                    user = usr;
                }
            }
        } catch (DAOException e) {
            throw new ServiceGetAllUsersException("Users were not received.");
        }
        
		return user;
	}
	
	private boolean isUserExist(User user) throws ServiceException {
		try {
			if (userDAO.isUserExist(user)) {
				return true;
			}
		} catch (DAOException e) {
			throw new ServiceGetAllUsersException("Users were not received.", e);
		}
		
		return false;
	}
}
