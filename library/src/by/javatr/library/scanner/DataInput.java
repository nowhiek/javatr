package by.javatr.library.scanner;

import java.util.Scanner;

public final class DataInput {

    public int inputIntFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            scanner.next();
        }

        return scanner.nextInt();
    }

    public String inputStringFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNext()){
            scanner.next();
        }

        return scanner.next();
    }
}
