package by.javatr.array.entity;

import by.javatr.array.entity.exception.InvalidArrayException;
import by.javatr.array.service.NumberOperation;
import by.javatr.array.service.SearchService;
import by.javatr.array.service.SortService;
import by.javatr.array.service.StringOperation;
import by.javatr.array.service.validator.ArrayLengthValidator;

public final class Array <T extends Number & Comparable> implements SortService, SearchService {
    // #TODO class NumberOperation is compared only as an integer and it was not possible to implement the class so that it does not depend on the task
    private T[] array ;
    private int length;

    public Array(){ }

    public Array(Byte[] array) {
        this.array = (T[])array;
        this.length = array.length;
    }

    public Array(Short[] array) {
        this.array = (T[]) array;
        this.length = array.length;
    }

    public Array(Integer[] array) {
        this.array = (T[]) array;
        this.length = array.length;
    }

    public Array(Long[] array) {
        this.array = (T[]) array;
        this.length = array.length;
    }

    public Array(T[] array) {
        this.array = array;
        this.length = array.length;
    }

    public Array(Array array) {
        this.array = (T[]) array.getArray();
        this.length = array.length;
    }

    public T[] getArray() {
        if (!new ArrayLengthValidator().validate(array))
            return (T[])new Number[0];

        T[] clone = (T[]) new Number[array.length];

        for (int i = 0; i < clone.length; i++){
            clone[i] = array[i];
        }

        return clone;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getArrayLength(){
        return length;
    }

    public T getMaximumValue() throws InvalidArrayException{
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        T max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) == -1) {
                max = array[i];
            }
        }

        return max;
    }

    public T getMinimalValue() throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        T min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (min.compareTo(array[i]) == 1) {
                min = array[i];
            }
        }

        return min;
    }

    private int getCountOnlyPrimeNumbersInArray(){
        int result = 0;

        NumberOperation operation = new NumberOperation();

        for (int i = 0; i < array.length; i++){
            if (operation.isPrimeNumber((int)array[i])){ // #TODO
                result++;
            }
        }

        return result;
    }

    public Array getOnlyPrimeNumbersInArray() throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        NumberOperation operation = new NumberOperation();

        int count = 0;
        Number[] tmp = new Number[getCountOnlyPrimeNumbersInArray()];

        for (int i = 0; i < array.length; i++){
            if (operation.isPrimeNumber((int)array[i])) { // #TODO
                tmp[count++] = array[i];
            }
        }

        return new Array(tmp);
    }

    private int getCountOnlyFibonachiNumbersInArray(){
        int result = 0;

        NumberOperation operation = new NumberOperation();

        for (int i = 0; i < array.length; i++){
            if (operation.isFibonachiNumber((int)array[i])){ // #TODO
                result++;
            }
        }

        return result;
    }

    public Array getOnlyFibonachiNumbersInArray() throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        NumberOperation operation = new NumberOperation();

        int count= 0;
        Number[] tmp = new Number[getCountOnlyFibonachiNumbersInArray()];

        for (int i = 0; i < array.length; i++){
            if (operation.isFibonachiNumber((int)array[i])) // #TODO
                tmp[count++] = array[i];
        }

        return new Array(tmp);
    }

    private int getCountOnlyThreeNotSameDigitsInArray(){
        int result = 0;

        StringOperation operation = new StringOperation();

        for (int i = 0; i < array.length; i++){
            if (operation.isThreeNotSameDigits(String.valueOf(Math.abs((int)array[i])))){ // #TODO
                result++;
            }
        }

        return result;
    }

    public Array getOnlyThreeNotSameDigitsInArray() throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        StringOperation operation = new StringOperation();

        int count = 0;
        Number[] tmp = new Number[getCountOnlyThreeNotSameDigitsInArray()];

        for (int i = 0; i < array.length; i++){
            if (operation.isThreeNotSameDigits(String.valueOf(Math.abs((int)array[i])))) // #TODO
                tmp[count++] = array[i];
        }

        return new Array(tmp);
    }

    @Override
    public int binarySearch(Number element) throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        return rank((T)element, 0, array.length - 1);
    }

    private int rank(T element, int low, int high) {
        int mid = low + (high - low) / 2;

        if (mid > high)
            return -1;

        if (element.compareTo(array[mid]) == -1){
            return rank(element, low, mid - 1);
        }else if (element.compareTo(array[mid]) == 1){
            return rank(element, mid + 1, high);
        }else {
            return mid;
        }
    }

    @Override
    public void bubbleSort() throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        T tmp;

        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length - i; j++){
                if (array[j - 1].compareTo(array[j]) == 1){
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    private void heapify(T[] arr, int n, int i) {
        int high = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].compareTo(arr[high]) == 1)
            high = left;

        if (right < n && arr[right].compareTo(arr[high]) == 1)
            high = right;

        if (high != i)
        {
            T swap = arr[i];
            arr[i] = arr[high];
            arr[high] = swap;

            heapify(arr, n, high);
        }
    }

    @Override
    public void heapSort() throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        for (int i = length - 1; i >= 0; i--)
        {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    @Override
    public void quickSort(int low, int high) throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        int middle = low + (high - low) / 2;
        T element = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(element) == -1) {
                i++;
            }

            while (array[j].compareTo(element) == 1) {
                j--;
            }

            if (i <= j) {
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }

    private void merge(T[] arr, int left, int mid, int right) {
        int lengthFirstSubArray = mid - left + 1;
        int lengthSecondSubArray = right - mid;

        T[] L = (T[])new Number[lengthFirstSubArray];
        T[] R = (T[])new Number[lengthSecondSubArray];

        for (int i = 0; i < lengthFirstSubArray; ++i)
            L[i] = arr[left + i];

        for (int j = 0; j < lengthSecondSubArray; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < lengthFirstSubArray && j < lengthSecondSubArray)
        {
            if (L[i].compareTo(R[j]) == -1 || L[i].compareTo(R[j]) == 0)
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < lengthFirstSubArray)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < lengthSecondSubArray)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    @Override
    public void mergeSort(int low, int high) throws InvalidArrayException {
        if (!new ArrayLengthValidator().validate(array))
            throw new InvalidArrayException("Array has an invalid length.");

        if (low < high)
        {
            int mid = (low + high) / 2;

            mergeSort(low, mid);
            mergeSort(mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        if (new ArrayLengthValidator().validate(array)) {
            for (int i = 0; i < array.length; i++) {
                result = result * prime + Integer.hashCode(array[i].hashCode());
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
                if (!array[i].equals(tmp.array[i])){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (new ArrayLengthValidator().validate(array)) {
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
