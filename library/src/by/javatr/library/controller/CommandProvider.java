package by.javatr.library.controller;

import by.javatr.library.controller.command.Command;
import by.javatr.library.controller.command.CommandEnum;
import by.javatr.library.controller.command.impl.*;
import by.javatr.library.controller.command.impl.book.*;
import by.javatr.library.controller.command.impl.user.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandEnum, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandEnum.ADD_BOOK, new AddBook());
        repository.put(CommandEnum.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandEnum.GET_BOOK, new GetBook());
        repository.put(CommandEnum.UPDATE_BOOK, new UpdateBook());
        repository.put(CommandEnum.GET_ALL_BOOKS, new GetAllBooks());
        repository.put(CommandEnum.SORT_BOOKS, new SortBooks());
        repository.put(CommandEnum.ADD_USER, new AddUser());
        repository.put(CommandEnum.REMOVE_USER, new RemoveUser());
        repository.put(CommandEnum.UPDATE_USER, new UpdateUser());
        repository.put(CommandEnum.GET_USER, new GetUser());
        repository.put(CommandEnum.GET_ALL_USERS, new GetAllUsers());
        repository.put(CommandEnum.SORT_USERS, new SortUsers());
        repository.put(CommandEnum.SIGN_IN, new SignIn());
        repository.put(CommandEnum.WRONG_METHOD, new WrongMethod());
    }

    public Command getCommand(String commandName) {
        CommandEnum commandEnum = null;
        Command command = null;

        try{
            commandEnum = CommandEnum.valueOf(commandName.toUpperCase());
            command = repository.get(commandEnum);
        }catch (IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandEnum.WRONG_METHOD);
        }

        return command;
    }
}
