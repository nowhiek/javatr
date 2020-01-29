package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.entity.User;
import by.javatr.library.service.impl.UserServiceImpl;

public class GetUser implements Command {

    @Override
    public String execute(String request) {
        UserServiceImpl impl = new UserServiceImpl();

        String currentCommand = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));
        System.out.println(currentCommand);
        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        switch (currentCommand){
            case "BY_ID" : {
                int id = Integer.parseInt(split[0]);
                return impl.findEntityById(id).toString();
            }
            case "BY_NAME" : {
                String name = split[0];
                return impl.findEntityByName(name).toString();
            }
            default : return new User().toString();
        }
    }
}
