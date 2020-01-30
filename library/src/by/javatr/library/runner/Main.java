package by.javatr.library.runner;

import by.javatr.library.controller.Controller;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.scanner.DataInput;

public class Main {

    public static void main(String[] args) throws DAOException {
        Controller controller = new Controller();
        DataInput input = new DataInput();

        boolean flag = false;

        while (true){
            if (!flag){
                System.out.print("Input login : ");
                String login = input.inputStringFromConsole();

                System.out.print("Input password : ");
                String pass = input.inputStringFromConsole();

                String result = controller.executeTask("SIGN_IN?".concat(login + "&").concat(pass));

                if (result.equals("Success")){
                    flag = true;
                    pressAnyKeyToContinue();
                }
            } else {
                System.out.println("1) User options.\n"
                        + "2) Book options.");

                int operation = input.inputIntFromConsole();
                int inOperation = 0;

                switch (operation){
                    case 1 : {
                        System.out.println("1) Get all books.\n"
                                + "2) Get book by :\n"
                                + "3) Sort books by :\n"
                                + "4) Update book :\n"
                                + "5) Remove book :");

                        inOperation = input.inputIntFromConsole();

                        switch (inOperation){
                            case 1 : {
                                String result = controller.executeTask("GET_ALL_BOOKS?");

                                System.out.println(result);
                            } default : {

                            }
                        }

                        pressAnyKeyToContinue();
                    } case 2 : {

                    } default : {

                    }
                }
            }
        }
        //System.out.println(controller.executeTask("UPDATE_USER?1&Test&1234&User&1&TestTest&1234567&Admin"));

        //System.out.println(controller.executeTask("GET_ALL_USERS?"));

    }

    private static int mainMenu(){
        return 0;
    }

    private static void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }
        catch(Exception e){

        }
    }
}
