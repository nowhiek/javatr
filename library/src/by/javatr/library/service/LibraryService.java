package by.javatr.library.service;

import by.javatr.library.exception.service.ServiceException;

import java.util.Comparator;
import java.util.List;

public interface LibraryService <E>{

    List<E> getAll() throws ServiceException;
    boolean create(E entity) throws ServiceException;
    boolean remove(int id) throws ServiceException;
    boolean update(E oldEntity, E newEntity) throws ServiceException;
    E findEntityById(int id) throws ServiceException;
    E findEntityByName(String name) throws ServiceException;
    List<E> sortEntitiesByComparator(Comparator comparator) throws ServiceException;
}
