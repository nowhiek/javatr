package by.javatr.array.service;

import by.javatr.array.entity.exception.InvalidArrayException;

public interface SearchService {
    int binarySearch(Number element) throws InvalidArrayException;
}
