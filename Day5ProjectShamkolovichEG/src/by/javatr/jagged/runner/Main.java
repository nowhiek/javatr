package by.javatr.jagged.runner;

import by.javatr.jagged.entity.Jagged;
import by.javatr.jagged.generator.JaggedGenerator;
import by.javatr.jagged.service.comparator.impl.SortJaggedByMaxValueInRow;
import by.javatr.jagged.service.comparator.impl.SortJaggedBySumValuesInRow;
import by.javatr.jagged.service.impl.JaggedSort;
import by.javatr.jagged.service.comparator.impl.SortJaggedByMinValueInRow;

public class Main {

    public static void main(String[] args) {

        int[][] array = new JaggedGenerator().generateIntegerNumbersInJagged(4, 1 , 10);
        Jagged jagged = new Jagged(array);
        System.out.println(jagged.toString());

        JaggedSort s = new JaggedSort();

        s.bubbleSortByComparator(array, new SortJaggedByMinValueInRow());

        System.out.println(jagged.toString());
        s.bubbleSortByComparator(array, new SortJaggedByMaxValueInRow());

        System.out.println(jagged.toString());
        s.bubbleSortByComparator(array, new SortJaggedBySumValuesInRow());

        System.out.println(jagged.toString());
    }
}
