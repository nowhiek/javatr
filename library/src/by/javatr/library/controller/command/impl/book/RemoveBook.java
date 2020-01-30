package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;

public class RemoveBook implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        int id = Integer.parseInt(split[0]);

        try{
            libraryService.remove(id);
        } catch (ServiceException e) {
            return e.getMessage();
        }

        return "Book deleted.";
    }
}
