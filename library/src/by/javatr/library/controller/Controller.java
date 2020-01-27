package by.javatr.library.controller;

import by.javatr.library.controller.command.Command;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request){
        Command currentCommand = provider.getCommand(request);

        String response = currentCommand.execute(request);

        return response;
    }
}
