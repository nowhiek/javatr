package by.javatr.array.service;

import by.javatr.array.entity.exception.InvalidArrayException;

public interface SortService {

    void bubbleSort() throws InvalidArrayException;
    void heapSort() throws InvalidArrayException;
    void quickSort(int low, int high) throws InvalidArrayException;
    void mergeSort(int low, int high) throws InvalidArrayException;
}
