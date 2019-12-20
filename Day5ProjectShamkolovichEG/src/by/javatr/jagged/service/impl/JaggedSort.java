package by.javatr.jagged.service.impl;

import by.javatr.jagged.service.JaggedSortService;

import java.util.Comparator;

public class JaggedSort implements JaggedSortService {

    @Override
    public void bubbleSortByComparator(int[][] array, Comparator<int[]> comparator){
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (comparator.compare(array[j], array[j + 1]) > 0)
                {
                    int[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
