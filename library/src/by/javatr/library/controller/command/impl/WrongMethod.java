package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;

public class WrongMethod implements Command {

    @Override
    public String execute(String request) {
        return "You have some problems.";
    }
}
