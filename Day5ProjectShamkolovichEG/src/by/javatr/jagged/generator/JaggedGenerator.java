package by.javatr.jagged.generator;

public class JaggedGenerator {

    public int[][] generateIntegerNumbersInJagged(int size, int min, int max) {
        int[][] result = new int[size][size];

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = randomValueInRange(min, max);
            }
        }

        return result;
    }

    private int randomValueInRange(int min, int max) {
        if (min >= max){
            int tmp = max;
            max = min;
            min = tmp;
        }

        max -= min;

        return (int)(Math.random() * ++max) + min;
    }
}
