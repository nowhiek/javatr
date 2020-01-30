package by.javatr.library.controller.command.impl.user;

import by.javatr.library.controller.command.Command;
import by.javatr.library.bean.Role;
import by.javatr.library.bean.User;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.UserServiceImpl;

public class AddUser implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl libraryService = serviceFactory.getUserService();

        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        int id = Integer.parseInt(split[0]);
        String userName = split[1];
        String password = split[2];

        User user = new User(id, userName, password, Role.USER);

        try {
            libraryService.create(user);
        } catch (ServiceException e) {
            return e.getMessage();
        }

        return "User added.";
    }
}
