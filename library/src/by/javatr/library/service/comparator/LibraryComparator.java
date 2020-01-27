package by.javatr.library.service.comparator;

import java.util.Comparator;

public interface LibraryComparator <E> extends Comparator <E> {
    int compare(E firstEntity, E secondEntity);
}
