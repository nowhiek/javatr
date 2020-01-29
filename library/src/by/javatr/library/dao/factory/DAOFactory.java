package by.javatr.library.dao.factory;

import by.javatr.library.dao.factory.impl.XmlDAOFactory;
import by.javatr.library.dao.impl.XmlBookDAO;
import by.javatr.library.dao.impl.XmlUserDAO;

public abstract class DAOFactory {

    private static final String XML = "XML";

    public abstract XmlBookDAO getBookDAO();
    public abstract XmlUserDAO getUserDAO();

    public static DAOFactory getDAOFactory(String temp){
        switch (temp){
            case XML :
                return new XmlDAOFactory();
            default :
                return null;
        }
    }
}
