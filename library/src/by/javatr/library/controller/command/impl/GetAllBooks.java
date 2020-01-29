package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.service.impl.BookServiceImpl;

public class GetAllBooks implements Command {

    @Override
    public String execute(String request) {
        BookServiceImpl impl = new BookServiceImpl();

        return impl.getAll().toString();
    }
}
