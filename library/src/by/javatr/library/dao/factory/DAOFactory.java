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
        String result;

        Properties properties = new Properties();

        try (FileInputStream fs = new FileInputStream("resources/config/config.properties")){
            properties.load(fs);

            result = properties.getProperty(property);
        } catch (IOException e) {
            result = "resources/books.xml";
        }

        return result;
    }

    public BookDAO getBookDAO(){
        return bookDAOImpl;
    }

    public UserDAO getUserDAO(){
        return userDAOImpl;
    }
}
