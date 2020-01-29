package by.javatr.library.dao.factory.impl;

import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.dao.impl.XmlBookDAO;
import by.javatr.library.dao.impl.XmlUserDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlDAOFactory extends DAOFactory {

    private static String fileBooks;
    private static String fileUsers;
    static{
        FileInputStream fs;
        Properties property = new Properties();

        try {
            fs = new FileInputStream("src/by/javatr/library/resources/config/config.properties");
            property.load(fs);

            fileBooks = property.getProperty("file.books");

            fileUsers = property.getProperty("file.users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public XmlBookDAO getBookDAO() {
        return new XmlBookDAO("src/by/javatr/library/resources/" + fileBooks);
    }

    @Override
    public XmlUserDAO getUserDAO() {
        return new XmlUserDAO("src/by/javatr/library/resources/" + fileUsers);
    }
}
