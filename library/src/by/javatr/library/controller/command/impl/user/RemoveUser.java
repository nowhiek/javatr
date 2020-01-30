package by.javatr.library.controller.command.impl.user;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.UserServiceImpl;

public class RemoveUser implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl libraryService = serviceFactory.getUserService();

        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        int id = Integer.parseInt(split[0]);

        try{
            libraryService.remove(id);
        } catch (ServiceException e) {
            return e.getMessage();
        }

        return "User deleted.";
    }
}
