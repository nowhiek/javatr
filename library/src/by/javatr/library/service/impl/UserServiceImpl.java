package by.javatr.library.service.impl;

import by.javatr.library.bean.User;
import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.dao.impl.UserDAO;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.exception.service.*;
import by.javatr.library.service.LibraryService;
import by.javatr.library.service.validator.impl.IdentifierValidator;
import by.javatr.library.service.validator.impl.NameValidator;
import by.javatr.library.service.validator.impl.UserValidator;

import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements LibraryService <User> {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public List<User> getAll() throws ServiceException{
        List<User> all = null;

        try {
            all = userDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceGetAllUsersException("Users were not received.", e);
        }

        if (all.isEmpty())
            throw new ServiceEmptyDataException("No users.");

        return all;
    }

    @Override
    public boolean create(User entity) throws ServiceException {
        try {
            return (!isEntityExist(entity)) && userDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceCreateUserException("The user was not created.", e);
        }
    }

    @Override
    public boolean remove(int id) throws ServiceException {
        if (!new IdentifierValidator().validate(id))
            throw new ServiceIdentifierNotCorrectException("You entered not valid id.");

        try {
            return (findEntityById(id) != null && userDAO.remove(id));
        } catch (DAOException e) {
            throw new ServiceRemoveUserException("The user was not deleted.", e);
        }
    }

    @Override
    public boolean update(User oldEntity, User newEntity) throws ServiceException {
        if (!new UserValidator().validate(newEntity))
            throw new ServiceUserNotCorrectException("User was not correct.");

        try {
            return (findEntityById((int) oldEntity.getIdUser()) != null && userDAO.update(oldEntity, newEntity));
        } catch (DAOException e) {
            throw new ServiceUpdateUserException("The user was not updated.", e);
        }
    }

    @Override
    public User findEntityById(int id) throws ServiceException {
        if (!new IdentifierValidator().validate(id))
            throw new ServiceIdentifierNotCorrectException("You entered not valid id.");

        User user = null;

        try {
            user = userDAO.getEntityById(id);
        } catch (DAOException e) {
            throw new ServiceGetAllUsersException("User was not received.", e);
        }

        if (user == null)
            throw new ServiceUserNotFoundException("This user not founded.");

        return user;
    }

    @Override
    public List<User> sortEntitiesByComparator(Comparator comparator) throws ServiceException {
        List<User> users = null;

        try {
            users = userDAO.getAll();

            users.sort(comparator);
        } catch (DAOException e) {
            throw new ServiceGetAllUsersException("Users were not received.", e);
        }

        return users;
    }

    @Override
    public User findEntityByName(String userName) throws ServiceException {
        if (!new NameValidator().validate(userName))
            throw new ServiceNameNotCorrectException("You entered not valid name.");

        List<User> users = null;
        User user = null;

        try {
            users = userDAO.getAll();

            for (User usr : users) {
                if (usr.getNameUser().equals(userName)) {
                    user = usr;
                }
            }
        } catch (DAOException e) {
            throw new ServiceGetAllUsersException("Users were not received.");
        }

        if (user == null)
            throw new ServiceUserNotFoundException("This user not founded.");

        return user;
    }

    private boolean isEntityExist(User entity) throws ServiceException {
        if (!new UserValidator().validate(entity))
            throw new ServiceUserNotCorrectException("User was not correct.");

        try {
            if (userDAO.isUserExist(entity))
                throw new ServiceCreateUserException("This user was already exist.");
        } catch (DAOException e) {
            throw new ServiceGetAllUsersException("Users were not received.", e);
        }

        return false;
    }
}
