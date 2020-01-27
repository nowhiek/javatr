package by.javatr.library.dao;

import java.util.List;

public interface LibraryDAO <E, K>{

    List<E> getAll();
    E getEntityById(K id);
    boolean update(E oldEntity, E newEntity);
    boolean create(E entity);
    boolean delete(K id);
}
