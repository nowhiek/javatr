package by.javatr.library.dao.factory;

import by.javatr.library.dao.LibraryDAO;
import by.javatr.library.dao.factory.impl.XmlDAOFactory;

public abstract class DAOFactory {

    private static final int XML = 1;

    public abstract LibraryDAO getBookDAO();
    public abstract LibraryDAO getUserDAO();

    public static DAOFactory getDAOFactory(int temp){
        switch (temp){
            case XML :
                return new XmlDAOFactory();
            default :
                return null;
        }
    }
}
