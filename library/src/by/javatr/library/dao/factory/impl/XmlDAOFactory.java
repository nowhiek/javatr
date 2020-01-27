package by.javatr.library.dao.factory.impl;

import by.javatr.library.dao.LibraryDAO;
import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.dao.impl.XmlBookDAO;
import by.javatr.library.dao.impl.XmlUserDAO;

public class XmlDAOFactory extends DAOFactory {
    @Override
    public LibraryDAO getBookDAO() {
        return new XmlBookDAO("src/by/javatr/library/resources/books.xml");
    }

    @Override
    public LibraryDAO getUserDAO() {
        return new XmlUserDAO("src/by/javatr/library/resources/users.xml");
    }
}
