package by.javatr.jagged.service.comparator.impl;

import by.javatr.jagged.service.impl.ArrayOperation;
import by.javatr.jagged.service.comparator.ArrayComparator;

public final class SortJaggedBySumValuesInRow implements ArrayComparator {

    @Override
    public int compare(int[] arr1, int[] arr2) {
        ArrayOperation operation = new ArrayOperation();

        int sumArr1 = operation.getSumValueInArray(arr1);
        int sumArr2 = operation.getSumValueInArray(arr2);

        return Integer.compare(sumArr1, sumArr2);
    }
}
