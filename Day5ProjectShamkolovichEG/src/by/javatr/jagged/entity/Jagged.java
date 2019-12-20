package by.javatr.jagged.entity;

import by.javatr.jagged.service.validator.JaggedLengthValidator;

public class Jagged {
    private int[][] array;

    public Jagged() {
        this.array = new int[0][0];
    }

    public Jagged(int[][] array) {
        this.array = array;
    }

    public int[][] getArray() {
        if (!new JaggedLengthValidator().validate(array))
            return new int[0][0];

        int[][] clone = new int[array.length][];

        for (int i = 0; i < array.length; i++){
            clone[i] = new int[array[i].length];

            for (int j = 0; j < array[i].length; j++){
                clone[i][j] = array[i][j];
            }
        }

        return clone;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        if (new JaggedLengthValidator().validate(array)) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    result = result * prime + Integer.valueOf(array[i][j]).hashCode();
                }
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

        Jagged tmp = (Jagged) obj;

        if (array == null){
            if (tmp.array != null)
                return false;
        }else if (array.length != tmp.array.length){
            return false;
        }else {
            for (int i = 0; i < array.length; i++){
                if (array[i] != tmp.array[i])
                    return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (new JaggedLengthValidator().validate(array)) {
            sb.append("[" + getClass().getName() + " - \n");

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sb.append("\t".concat(String.valueOf(array[i][j])).concat("\t"));
                }

                sb.append("\n");
            }
            sb.delete(sb.length() - 1, sb.length()).append("\n]");
        }

        return sb.toString();
    }
}
