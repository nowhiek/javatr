package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.entity.User;
import by.javatr.library.service.impl.UserServiceImpl;

public class SignIn implements Command {

    @Override
    public String execute(String request) {
        UserServiceImpl impl = new UserServiceImpl();

        String[] split = request.substring(request.indexOf("?") + 1).split(PARAM_DELIMITER);

        String login = split[0];
        String password = split[1];

        User user = impl.findEntityByName(login);

        return (user.getPasswordUser() != null && user.getPasswordUser().equals(password)) ? "Success" : "Fail";
    }
}
