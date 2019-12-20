package by.javatr.jagged.service.comparator.impl;

import by.javatr.jagged.service.impl.ArrayOperation;
import by.javatr.jagged.service.comparator.ArrayComparator;

public final class SortJaggedByMaxValueInRow implements ArrayComparator {

    @Override
    public int compare(int[] arr1, int[] arr2) {
        ArrayOperation operation = new ArrayOperation();

        int maxArr1 = operation.getMaximalValueInArray(arr1);
        int maxArr2 = operation.getMaximalValueInArray(arr2);

        return Integer.compare(maxArr1, maxArr2);
    }
}
