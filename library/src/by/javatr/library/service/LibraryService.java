package by.javatr.library.service;

import java.util.Comparator;
import java.util.List;

public interface LibraryService <E>{

    List<E> getAll();
    boolean create(E entity);
    boolean remove(E entity);
    E findEntityById(int id);
    E findEntityByName(String name);
    List<E> sortEntitiesByComparator(Comparator comparator);
}
