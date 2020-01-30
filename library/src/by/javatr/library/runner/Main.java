package by.javatr.library.runner;

import by.javatr.library.bean.Role;
import by.javatr.library.controller.Controller;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.scanner.DataInput;

public class Main {

    private static final DataInput input = new DataInput();
    private static final Controller controller = new Controller();

    public static void main(String[] args) throws DAOException {
        boolean flag = false;
        Role userRole = Role.USER;

        while (true){
            if (!flag){
                System.out.print("Input login : ");
                String login = input.inputStringFromConsole();

                System.out.print("Input password : ");
                String pass = input.inputStringFromConsole();

                String result = controller.executeTask("SIGN_IN?".concat(login + "&").concat(pass));
                System.out.println(result);

                if (result.contains("Success")){
                    flag = true;
                    userRole = Role.valueOf(result.substring(result.lastIndexOf(' ') + 1).toUpperCase());

                    pressAnyKeyToContinue();
                }
            } else {
                if (userRole == Role.USER){
                    userMenu();
                } else {
                    adminMenu();
                }
            }
        }
    }

    private static void userMenu(){
        System.out.println("1) User options.\n"
                + "2) Exit.");
        int operation = input.inputIntFromConsole();

        switch (operation){
            case 1 : {
                System.out.println("1) Get all books.\n"
                        + "2) Get book by :\n"
                        + "3) Sort books by :");

                int inOperation = input.inputIntFromConsole();

                StringBuilder result = new StringBuilder();

                switch (inOperation){
                    case 1 : {
                        result.append(controller.executeTask("GET_ALL_BOOKS?"));

                        break;
                    }
                    case 2 : {
                        System.out.println("1) Get book by id : \n"
                                + "2) Get book by name : \n"
                                + "3) Get book by author : \n"
                                + "4) Get book by publishing : \n"
                                + "5) Get book by count pages :");

                        int inGetBook = input.inputIntFromConsole();

                        switch (inGetBook){
                            case 1 : {
                                System.out.print("Input id book : ");
                                int idBook = input.inputIntFromConsole();

                                result.append(controller.executeTask("GET_BOOK?BY_ID?".concat(String.valueOf(idBook)).concat("&")));
                                break;
                            } case 2 : {
                                System.out.print("Input name book : ");
                                String nameBook = input.inputStringFromConsole();

                                result.append(controller.executeTask("GET_BOOK?BY_NAME?".concat(nameBook).concat("&")));
                                break;
                            } case 3 : {
                                System.out.print("Input author first name : ");
                                String firstName = input.inputStringFromConsole();

                                System.out.print("Input author second name : ");
                                String secondName = input.inputStringFromConsole();

                                result.append(controller.executeTask("GET_BOOK?BY_AUTHOR?".concat(firstName).concat("&").concat(secondName)));
                                break;
                            } default : {

                            }
                        }

                        break;
                    } case 3: {
                        System.out.println("1) Sort books by id : \n"
                                + "2) Sort books by name : \n"
                                + "3) Sort books by author : \n"
                                + "4) Sort books by publishing : \n"
                                + "5) Sort books by count pages :");

                        break;
                    }
                    default : {
                        result = new StringBuilder();
                    }
                }

                System.out.println(result.toString());
                pressAnyKeyToContinue();
            } default : {

            }
        }
    }

    private static void adminMenu(){

    }

    private static void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch(Exception ignored){

        }
    }
}
