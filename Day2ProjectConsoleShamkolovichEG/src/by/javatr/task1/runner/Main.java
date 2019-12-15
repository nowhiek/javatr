package by.javatr.task1.runner;

import by.javatr.task1.util.Hello;

public class Main {

    public static void main(String[] args) {
        String name = null;

        if (args.length != 0){
            name = args[0];
        }

        String str = new Hello().message(name);
        System.out.println(str);
    }
}
