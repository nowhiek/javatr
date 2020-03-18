package by.epam.jwd.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.jwd.controller.command.Command;
import by.epam.jwd.controller.command.CommandName;
import by.epam.jwd.controller.command.impl.Registr;
import by.epam.jwd.controller.command.impl.SignIn;
import by.epam.jwd.controller.command.impl.WrongMethod;

public final class CommandProvider {
	
	private static final CommandProvider instance =  new CommandProvider();
	private final Map<CommandName, Command> repository = new HashMap<>();

    private CommandProvider(){
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTR, new Registr());
        repository.put(CommandName.WRONG_METHOD, new WrongMethod());
    }

    public Command getCommand(String commandName) {
        CommandName commandEnum = null;
        Command command = null;

        try{
            commandEnum = CommandName.valueOf(commandName.toUpperCase());
            command = repository.get(commandEnum);
        }catch (IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG_METHOD);
        }

        return command;
    }
    
    public static CommandProvider getInstance(){
        return instance;
    }
}
