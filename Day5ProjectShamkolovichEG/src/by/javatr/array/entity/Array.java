package by.javatr.array.entity;

import by.javatr.array.service.InvalidArrayException;
import by.javatr.array.service.ArraySortOption;
import by.javatr.array.service.NumberOperation;

public class Array implements ArraySortOption {

    private int[] array;

    public int[] getArray() {
        int[] clone = new int[array.length];

        for (int i = 0; i < clone.length; i++){
            clone[i] = array[i];
        }

        return clone;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Array(){ }

    public Array(int[] array) {
        this.array = array;
    }

    public Array(Array array){
        this.array = array.getArray();
    }

    public int getMaximumValue() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    public int getMinimalValue() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

    public Array getOnlyPrimeNumbersInArray() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        int count = 0;
        int[] tmp = new int[array.length];

        for (int i = 0; i < array.length; i++){
            if (NumberOperation.isPrimeNumber(array[i]))
                tmp[count++] = array[i];
        }

        return new Array(tmp);
    }

    public Array getOnlyFibonachiNumbersInArray() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        int count = 0;
        int[] tmp = new int[array.length];

        for (int i = 0; i < array.length; i++){
            if (NumberOperation.isFibonachiNumber(array[i]))
                tmp[count++] = array[i];
        }

        return new Array(tmp);
    }

    private int rank(int element, int low, int high) throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        bubbleSort();

        int mid = low + (high - low) / 2;

        if (mid > high)
            return -1;


        if (element < array[mid]){
            return rank(element, low, mid - 1);
        }else if (element > array[mid]){
            return rank(element, mid + 1, high);
        }else {
            return mid;
        }
    }

    public int binarySearch(int element) throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        return rank(element, 0, array.length - 1);
    }

    @Override
    public void bubbleSort() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        int tmp;

        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length - i; j++){
                if (array[j - 1] > array[j]){
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    @Override
    public void selectionSort() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        for (int i = 0; i < array.length; i++){
            int pos = i;
            int step = array[i];

            for (int j = 1 + i; j < array.length; j++){
                if (step > array[j]){
                    pos = j;
                    step = array[j];
                }
            }

            array[pos] = array[i];
            array[i] = step;
        }
    }

    @Override
    public void insertSort() throws InvalidArrayException {
        if (array == null || array.length == 0)
            throw new InvalidArrayException("Array has an invalid length.");

        int i;
        int j;
        int tmp;

        for (i = 1; i < array.length; i++)
        {
            tmp = array[i];
            j = i;

            while (j > 0 && array[j - 1] > tmp)
            {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = tmp;
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                result = result * prime + Integer.hashCode(array[i]);
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Array tmp = (Array) obj;

        if (array == null){
            if (tmp.array != null)
                return false;
        }else if (array.length != tmp.array.length){
            return false;
        }else {
            for(int i = 0; i < array.length; i++){
                if (array[i] != tmp.array[i]){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (array != null && array.length != 0) {
            sb.append("[" + getClass().getName() + " - ");

            for (int i = 0; i < array.length; i++) {
                sb.append(array[i] + ", ");
            }

            sb.delete(sb.length() - 2, sb.length()).append("]");
        }else{
            sb.append("[" + getClass().getName() + " - empty]");
        }

        return sb.toString();
    }
}
