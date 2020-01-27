package by.javatr.library.controller;

import by.javatr.library.controller.command.Command;
import by.javatr.library.controller.command.CommandEnum;
import by.javatr.library.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandEnum, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandEnum.ADD_BOOK, new AddBook());
        repository.put(CommandEnum.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandEnum.GET_BOOK, new GetBook());
        repository.put(CommandEnum.REGISTER, new Register());
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
