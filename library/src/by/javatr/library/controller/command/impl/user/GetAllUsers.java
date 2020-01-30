package by.javatr.library.controller.command.impl.user;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.UserServiceImpl;

public class GetAllUsers implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl libraryService = serviceFactory.getUserService();

        try {
            return libraryService.getAll().toString();
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
