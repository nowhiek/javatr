package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;

public class GetAllBooks implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        try {
            return libraryService.getAll().toString();
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
