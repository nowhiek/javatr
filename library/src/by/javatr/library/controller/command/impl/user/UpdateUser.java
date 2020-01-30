package by.javatr.library.controller.command.impl.user;

import by.javatr.library.bean.Role;
import by.javatr.library.bean.User;
import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.UserServiceImpl;

public class UpdateUser implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl libraryService = serviceFactory.getUserService();

        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        int idOldUser = Integer.parseInt(split[0]);
        String nameOldUser = split[1];
        String passOldUser = split[2];
        Role roleOldUser = Role.valueOf(split[3].toUpperCase());

        int idNewUser = Integer.parseInt(split[4]);
        String nameNewUser = split[5];
        String passNewUser = split[6];
        Role roleNewUser = Role.valueOf(split[7].toUpperCase());

        User oldUser = new User(idOldUser, nameOldUser, passOldUser, roleOldUser);
        User newUser = new User(idNewUser, nameNewUser, passNewUser, roleNewUser);

        try{
            libraryService.update(oldUser, newUser);
        } catch (ServiceException e) {
            return e.getMessage();
        }

        return "User updated.";
    }
}
