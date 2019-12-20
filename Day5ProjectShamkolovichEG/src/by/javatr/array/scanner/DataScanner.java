package by.javatr.array.scanner;

import java.util.Scanner;

public final class DataScanner {

    public byte inputByteFromConsole(){
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextByte()){
            scanner.next();
        }

        return scanner.nextByte();
    }

    public short inputShortFromConsole(){
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextShort()){
            scanner.next();
        }

        return scanner.nextShort();
    }

    public int inputIntFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            scanner.next();
        }

        return scanner.nextInt();
    }

    public long inputLongFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextLong()){
            scanner.next();
        }

        return scanner.nextLong();
    }

    public String inputStringFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNext()){
            scanner.next();
        }

        return scanner.next();
    }
}
