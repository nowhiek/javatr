package by.javatr.array.service;

import by.javatr.array.entity.Array;

import java.io.*;
import java.util.Scanner;

public final class DataInput {

    public static int inputNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            scanner.next();
        }

        return scanner.nextInt();
    }

    public static Array inputNumbersFromFile(String path){
        String line = getLineFromFile(path);

        return StringOperation.getArrayFromLine(line);
    }

    private static String getLineFromFile(String path) {
        StringBuffer result = new StringBuffer();

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            result.append(reader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
