package by.javatr.library.controller;

import by.javatr.library.controller.command.Command;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char commandDelimiter = '?';

    public String executeTask(String request){
        String commandName = request.substring(0, request.indexOf(commandDelimiter));
        Command executionCommand = provider.getCommand(commandName);

        return executionCommand.execute(request);
    }
}
