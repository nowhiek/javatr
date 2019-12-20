package by.javatr.redactor.scanner;

import java.util.Scanner;

public final class DataScanner {

    public String inputStringFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNext()){
            scanner.next();
        }

        return scanner.next();
    }
}
