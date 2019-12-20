package by.javatr.jagged.service;

import java.util.Comparator;

public interface JaggedSortService {

    void bubbleSortByComparator(int[][] array, Comparator<int[]> comparator);
}
