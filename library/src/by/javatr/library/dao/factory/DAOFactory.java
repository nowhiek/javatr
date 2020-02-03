package by.javatr.library.dao.factory;

import by.javatr.library.dao.impl.BookDAO;
import by.javatr.library.dao.impl.UserDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO bookDAOImpl = new BookDAO();
    private final UserDAO userDAOImpl = new UserDAO();

    private DAOFactory(){ }

    public static DAOFactory getInstance(){
        return instance;
    }

    public static String getConnection(String property){
        Properties properties = new Properties();

        try (FileInputStream fs = new FileInputStream("src/resources/config/config.properties")){
            properties.load(fs);
        } catch (IOException e) {
            //logger
        }

        return properties.getProperty(property);
    }

    public BookDAO getBookDAO(){
        return bookDAOImpl;
    }

    public UserDAO getUserDAO(){
        return userDAOImpl;
    }
}
