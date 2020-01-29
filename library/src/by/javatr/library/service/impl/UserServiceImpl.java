package by.javatr.library.service.impl;

import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.dao.factory.impl.XmlDAOFactory;
import by.javatr.library.entity.User;
import by.javatr.library.service.LibraryService;
import by.javatr.library.service.validator.impl.IdentifierValidator;
import by.javatr.library.service.validator.impl.NameValidator;
import by.javatr.library.service.validator.impl.UserValidator;

import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements LibraryService<User> {

    @Override
    public List<User> getAll() {
        DAOFactory dao = DAOFactory.getDAOFactory("XML");
        List<User> all = dao.getUserDAO().getAll();

        return all;
    }

    @Override
    public boolean create(User entity) {
        DAOFactory dao = DAOFactory.getDAOFactory("XML");

        return (!isEntityExist(entity)) && dao.getUserDAO().create(entity);
    }

    @Override
    public boolean remove(User entity) {
        return false;
    }

    @Override
    public User findEntityById(int id) {
        if (!new IdentifierValidator().validate(id))
            System.out.println("Exception!");

        DAOFactory dao = DAOFactory.getDAOFactory("XML");

        return dao.getUserDAO().getEntityById(id);
    }

    @Override
    public List<User> sortEntitiesByComparator(Comparator comparator) {
        DAOFactory dao = DAOFactory.getDAOFactory("XML");
        List<User> users = dao.getUserDAO().getAll();

        users.sort(comparator);

        return users;
    }

    @Override
    public User findEntityByName(String userName) {
        if (!new NameValidator().validate(userName))
            System.out.println("Exception null or empty.");

        DAOFactory dao = DAOFactory.getDAOFactory("XML");
        List<User> users = dao.getUserDAO().getAll();

        for (User user : users) {
            if (user.getNameUser().equals(userName)) {
                return user;
            }
        }

        return new User();
    }

    private boolean isEntityExist(User entity) {
        if (!new UserValidator().validate(entity))
            System.out.println("Exception");

        DAOFactory dao = XmlDAOFactory.getDAOFactory("XML");

        return dao.getUserDAO().isUserExist(entity);
    }
}
