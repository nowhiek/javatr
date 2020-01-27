package by.javatr.library.service.impl;

import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.entity.User;
import by.javatr.library.service.LibraryService;
import by.javatr.library.service.validator.impl.IdentifierValidator;

import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements LibraryService<User> {

    @Override
    public List<User> getAll() {
        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<User> all = dao.getUserDAO().getAll();

        return all;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public boolean remove(User entity) {
        return false;
    }

    @Override
    public User findEntityById(int id) {
        if (!new IdentifierValidator().validate(id))
            System.out.println("Exception!");

        DAOFactory dao = DAOFactory.getDAOFactory(1);
        User user = (User) dao.getUserDAO().getEntityById(id);



        return user;
    }

    @Override
    public User findEntityByName(String name) {
        return null;
    }

    @Override
    public List<User> sortEntitiesByComparator(Comparator comparator) {
        return null;
    }

    public boolean isEntityExist(User entity) {
        return false;
    }
}
