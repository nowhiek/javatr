package by.javatr.library.dao;

import by.javatr.library.exception.dao.DAOException;

import java.util.List;

public interface LibraryDAO <E, K>{

    List<E> getAll() throws DAOException;
    E getEntityById(K id) throws DAOException;
    boolean update(E oldEntity, E newEntity) throws DAOException;
    boolean create(E entity) throws DAOException;
    boolean remove(K id) throws  DAOException;
}
