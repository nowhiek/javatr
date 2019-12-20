package by.javatr.jagged.service.comparator.impl;

import by.javatr.jagged.service.impl.ArrayOperation;
import by.javatr.jagged.service.comparator.ArrayComparator;

public final class SortJaggedByMinValueInRow implements ArrayComparator {

    @Override
    public int compare(int[] arr1, int[] arr2) {
        ArrayOperation operation = new ArrayOperation();

        int minArr1 = operation.getMinimalValueInArray(arr1);
        int minArr2 = operation.getMinimalValueInArray(arr2);

        return Integer.compare(minArr1, minArr2);
    }
}
