package by.javatr.library.controller.command.impl.user;

import by.javatr.library.controller.command.Command;
import by.javatr.library.bean.User;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.UserServiceImpl;

public class GetUser implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl libraryService = serviceFactory.getUserService();

        String currentCommand = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));
        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        try {
            switch (currentCommand) {
                case "BY_ID": {
                    int id = Integer.parseInt(split[0]);

                    return libraryService.findEntityById(id).toString();
                }
                case "BY_NAME": {
                    String name = split[0];

                    return libraryService.findEntityByName(name).toString();
                }
                default:
                    return new User().toString();
            }
        }catch (ServiceException e){
            return e.getMessage();// убиться тазиком, зачем ты такое делаешь?
        }
    }
}
