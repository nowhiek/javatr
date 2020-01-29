package by.javatr.library.controller.command;

public interface Command {
    String PARAM_DELIMITER = "&";

    String execute(String request);
}
