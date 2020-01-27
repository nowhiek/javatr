package by.javatr.library.service.comparator.impl;

import by.javatr.library.entity.User;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortUsersById implements LibraryComparator <User> {

    @Override
    public int compare(User firstEntity, User secondEntity) {
        return Long.compare(firstEntity.getIdUser(), secondEntity.getIdUser());
    }
}
